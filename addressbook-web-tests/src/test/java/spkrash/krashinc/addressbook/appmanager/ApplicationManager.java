package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Krash on 26.10.2016.
 */
public class ApplicationManager {
   WebDriver wd;

   private ContactHelper contactHelper;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private String browser;

   public ApplicationManager(String browser) {
      this.browser = browser;
   }

   public void init()
   {
      if (browser == BrowserType.FIREFOX) {
         wd = new FirefoxDriver();
      } else if (browser == BrowserType.CHROME){
         wd = new ChromeDriver();
      } else if (browser == BrowserType.EDGE) {
         wd = new EdgeDriver();
      }

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
