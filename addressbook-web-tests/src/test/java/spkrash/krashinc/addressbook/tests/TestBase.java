package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import spkrash.krashinc.addressbook.appmanager.ApplicationManager;

/**
 * Created by Krash on 26.10.2016.
 */
public class TestBase {

   protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   @BeforeSuite
   public void setUp() throws Exception
   {
      app.init();
   }

   @AfterSuite
   public void tearDown()
   {
      app.stop();
   }

}
