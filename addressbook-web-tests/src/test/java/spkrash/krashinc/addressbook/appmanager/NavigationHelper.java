package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Krash on 26.10.2016.
 */
public class NavigationHelper extends HelperBase
{

   public NavigationHelper(FirefoxDriver wd)
   {
      super(wd);
   }

   public void gotoGroupPage()
   {
      clickItem(By.linkText("groups"));
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   }

   public void gotoHomePage()
   {
      clickItem(By.linkText("home"));
      try
      {
         Thread.sleep(1000);
      } catch (InterruptedException e)
      {
         e.printStackTrace();
      }

   }
}
