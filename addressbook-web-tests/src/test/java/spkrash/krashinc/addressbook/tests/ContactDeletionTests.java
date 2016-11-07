package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactDeletionTests extends TestBase {
   @Test
   public void testContactDeletion()
   {
      app.getNavigationHelper().gotoHomePage();
      if(!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getContactHelper().initContactCreation();
         app.getContactHelper().fillContactForm(new ContactData("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com"));
         app.getContactHelper().confirmContactCreation();
         app.getContactHelper().returnToHomePage();
      }
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().submitAlert();
      app.getNavigationHelper().gotoHomePage();
   }
}
