package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Krash on 26.10.2016.
 */
public class SessionHelper extends HelperBase
{
   public SessionHelper(FirefoxDriver wd)
   {

      super(wd);
   }

   public void login(String username, String password)
   {
      fillTextField(By.name("user"), username);
      fillTextField(By.name("pass"), password);
      clickItem(By.xpath("//form[@id='LoginForm']/input[3]"));
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   }

}
