package spkrash.krashinc.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Krash on 11.12.2016.
 */
public class RegistrationHelper extends HelperBase{

   public RegistrationHelper(ApplicationManager app) {
      super(app);
   }

   public void start(String username, String email) {
      wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
      fillTextField(By.name("username"), username);
      fillTextField(By.name("email"), email);
      clickItem(By.xpath(".//*[@id='signup-form']/fieldset/span[2]/input")); // xpath я тут использовал вместо поиска
                                                                             // по value при помощи cssSelector (как в
                                                                             // учебном видео)чтобы не фейлиться
                                                                             // при локализированном Мантис
   }

   public void finish(String confirmationLink, String password) {
      wd.get(confirmationLink);
      fillTextField(By.name("password"), password);
      fillTextField(By.name("password_confirm"), password);
      clickItem(By.xpath(".//*[@id='account-update-form']/fieldset/span/input")); //xpath по той же причине что и выше
   }


   public void login(String username, String password) {
      wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
      fillTextField(By.name("username"), username);
      fillTextField(By.name("password"), password);
      clickItem(By.xpath("//*[@id=\"login-form\"]/fieldset/span/input"));
   }

   public boolean areThereUsersExceptAdministrator() {
      if (isElementPresent(By.xpath("//*[@id=\"manage-user-div\"]/table/tbody/tr[2]/td[1]"))){
         return true;
      }
      return false;
   }
}
