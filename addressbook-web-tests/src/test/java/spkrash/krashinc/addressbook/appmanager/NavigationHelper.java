package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Krash on 26.10.2016.
 */
public class NavigationHelper
{
   private FirefoxDriver wd;

   public NavigationHelper(FirefoxDriver wd)
   {
      this.wd = wd;
   }

   public void gotoGroupPage()
   {
      wd.findElement(By.linkText("groups")).click();
   }

   public void gotoHomePage()
   {
      wd.findElement(By.linkText("home")).click();
   }
}
