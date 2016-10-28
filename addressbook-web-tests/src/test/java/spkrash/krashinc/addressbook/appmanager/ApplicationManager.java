package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Krash on 26.10.2016.
 */
public class ApplicationManager
{
   FirefoxDriver wd;

   private ContactHelper contactHelper;
   private SessionHelper sessionHelper;
   private  NavigationHelper navigationHelper;
   private  GroupHelper groupHelper;

   public void init()
   {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      contactHelper = new ContactHelper(wd);
      sessionHelper = new SessionHelper(wd);
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      sessionHelper.login("admin", "secret");
   }

   public void stop()
   {
      wd.quit();
   }

   public GroupHelper getGroupHelper()
   {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper()
   {
      return navigationHelper;
   }

   public ContactHelper getContactHelper()
   {
      return contactHelper;
   }
}
