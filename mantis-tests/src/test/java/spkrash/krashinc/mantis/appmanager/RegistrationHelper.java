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
   }
}
