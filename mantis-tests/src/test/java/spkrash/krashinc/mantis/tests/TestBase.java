package spkrash.krashinc.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import spkrash.krashinc.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

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

   public boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
      MantisConnectPortType mc = app.soap().getMantisConnect();
      IssueData issueData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
      if (issueData.getStatus().getName().equals("closed")){
      return false;
      }
      return true;
   }

   public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
      if (isIssueOpen(issueId)) {
         throw new SkipException(String.format("Ignored because of issue: %s", issueId));
      }
   }
}
