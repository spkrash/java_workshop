package spkrash.krashinc.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import spkrash.krashinc.mantis.appmanager.ApplicationManager;

/**
 * Created by Krash on 26.10.2016.
 */
public class TestBase {

   protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

   @BeforeSuite
   public void setUp() throws Exception
   {
      app.init();
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown()
   {
      app.stop();
   }
}
