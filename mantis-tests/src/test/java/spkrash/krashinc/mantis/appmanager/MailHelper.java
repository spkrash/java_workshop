package spkrash.krashinc.mantis.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import spkrash.krashinc.mantis.model.MailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Krash on 11.12.2016.
 */
public class MailHelper {
   private ApplicationManager app;
   private Wiser wiser;

   public MailHelper(ApplicationManager app) {
      this.app = app;
      wiser = new Wiser();
   }

   public static MailMessage toModelMail(WiserMessage m) {
      try {
         MimeMessage mm = m.getMimeMessage();
         return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
      } catch (MessagingException e) {
         e.printStackTrace();
         return null;
      } catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }

   public List<MailMessage> waitForMail(int count, long timeout) throws MessagingException, IOException {
      long start = System.currentTimeMillis();
      while (System.currentTimeMillis() < start + timeout) {
         if (wiser.getMessages().size() >= count) {
            return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
         }
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      throw new Error("No mail :(");
   }

   public void start() {
      wiser = new Wiser();
      wiser.start();
   }

   public void stop() {
      wiser.stop();
   }
}
