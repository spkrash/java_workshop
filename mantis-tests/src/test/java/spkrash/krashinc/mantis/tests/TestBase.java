package spkrash.krashinc.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import spkrash.krashinc.mantis.appmanager.ApplicationManager;
import spkrash.krashinc.mantis.model.Issue;

import java.io.File;
import java.io.IOException;

/**
 * Created by Krash on 26.10.2016.
 */
public class TestBase {

   protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

   @BeforeSuite
   public void setUp() throws Exception
   {
      app.init();
      app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() throws IOException
   {
      app.ftp().restore("config_inc.php.bak", "config_inc.php");
      app.stop();
   }
   public boolean isIssueOpen(int issueId){
      return true;
   }

   public void skipIfNotFixed(int issueId) {
      if (isIssueOpen(issueId)) {
         throw new SkipException(String.format("Ignored because of issue: %s", issueId));
      }
   }
}
