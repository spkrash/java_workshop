package spkrash.krashinc.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import spkrash.krashinc.mantis.model.MailMessage;
import spkrash.krashinc.mantis.model.MantisUsers;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Krash on 11.12.2016.
 */
public class RegistrationTests extends TestBase {

   @Test
   public void testRegistration() throws IOException, MessagingException {
      app.mail().start();
      long now = System.currentTimeMillis();
      String user = String.format("user%s", now);
      String password = "password";
      String email = String.format("user%s@localhost.localdomain", now);
      app.registration().start(user, email);
      List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
      String confirmationLink = findConfirmationLink(mailMessages, email);
      app.registration().finish(confirmationLink, password);
      assertTrue(app.newSession().login(user, password));
      app.mail().stop();
   }

   @Test
   public void testChangePassword() throws IOException, MessagingException {

      HashSet<MantisUsers> mantisUsers = new HashSet<>();
      Connection conn;
      String password = "changedPsswd";

      try {
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=");

         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery("select id, username, email from mantis_user_table");
         while (rs.next()) {
            if (!"administrator".equals(rs.getString("username"))) {
               mantisUsers.add(new MantisUsers(rs.getInt("id"), rs.getString("username"), rs.getString("email")));
            }
         }
         if (mantisUsers.size() == 0) {
            testRegistration();
            rs = st.executeQuery("select id, username, email from mantis_user_table");
            while (rs.next()) {
               if (!"administrator".equals(rs.getString("username"))) {
                  mantisUsers.add(new MantisUsers(rs.getInt("id"), rs.getString("username"), rs.getString("email")));
               }
            }
         }

         app.mail().start();
         app.registration().login("administrator", "root");
         app.goTo().settings();
         app.goTo().userSettings();
         MantisUsers changedUser = mantisUsers.iterator().next();
         app.registration().resetPassword(changedUser.getUserName());
         List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
         String confirmLink = findConfirmationLink(mailMessages, changedUser.getEmail());
         app.registration().logout();
         app.registration().finish(confirmLink, password);
         assertTrue(app.newSession().login(changedUser.getUserName(), password));
         app.mail().stop();
         rs.close();
         st.close();
         conn.close();

      } catch (SQLException ex) {
         // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());
      }
   }


   private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
      MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      return regex.getText(mailMessage.text);
   }
}
