package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import spkrash.krashinc.addressbook.appmanager.ApplicationManager;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 26.10.2016.
 */
public class TestBase {

   protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
   Logger logger = LoggerFactory.getLogger(TestBase.class);

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

   @BeforeMethod
   public void logTestStart(Method m, Object[] p) {
      logger.info("Start test " + m.getName() + "with parameters " + Arrays.asList(p));

   }

   @AfterMethod(alwaysRun = true)
   public void logTestStop(Method m) {
      logger.info("Stop test " + m.getName());
   }

   public void verifyGroupListInUI() {
      if (Boolean.getBoolean("verifyUI")) {
         Groups dbGroups = app.db().groups();
         Groups uiGroups = app.group().all();
         assertThat(uiGroups, equalTo(dbGroups.stream()
               .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
               .collect(Collectors.toSet())));
      }
   }

   public void verifyContactListInUI() {
      if (Boolean.getBoolean("verifyUI")) {
         Contacts dbContacts = app.db().contacts();
         Contacts uiContacts = app.contact().all();
         assertThat(uiContacts, equalTo(dbContacts.stream()
               .map((c) -> new ContactData().withId(c.getId()).withFirstName(c.getFirstName())
                     .withLastName(c.getLastName()).withAddress(c.getAddress()).withAllEmail(c.getAllEmails())
                     .withAllPhones(c.getAllPhones())).collect(Collectors.toSet())));
      }
   }

}
