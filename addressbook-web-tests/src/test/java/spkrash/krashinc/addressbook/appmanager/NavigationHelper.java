package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

/**
 * Created by Krash on 26.10.2016.
 */
public class NavigationHelper extends HelperBase {

   public NavigationHelper(WebDriver wd)
   {
      super(wd);
   }

   /*   public void gotoGroupPage()
      {
         if (!Objects.equals(wd.getCurrentUrl(), "http://localhost/addressbook/group.php")) {
            clickItem(By.linkText("groups"));
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();

            }
         }

      }
   */
   public void gotoGroupPage() {
      if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new")))
      {
         return;
      }
         clickItem(By.linkText("groups"));

   }

   /*   public void gotoHomePage()
      {
         if (!Objects.equals(wd.getCurrentUrl(), "http://localhost/addressbook/")) {
            clickItem(By.linkText("home"));
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
      */
   public void gotoHomePage() {
   if(isElementPresent(By.id("maintable"))){
      return;
   }
      clickItem(By.linkText("home"));
   }

}
