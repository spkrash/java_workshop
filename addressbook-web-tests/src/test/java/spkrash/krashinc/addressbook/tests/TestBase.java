package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import spkrash.krashinc.addressbook.appmanager.ApplicationManager;

/**
 * Created by Krash on 26.10.2016.
 */
public class TestBase {

   protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   @BeforeMethod
   public void setUp() throws Exception
   {
      app.init();
   }

   @AfterMethod
   public void tearDown()
   {
      app.stop();
   }

}
