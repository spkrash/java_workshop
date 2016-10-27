package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase
{
   @Test
   public void testContactCreation()
   {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initContactCreation();
      app.getContactHelper().fillContactForm(new ContactData("Bruce", "B", "Wayne", "Batman", "Gotham City", "+38050000000", "batman@gotham.com"));
      app.getContactHelper().confirmContactCreation();
      app.getContactHelper().returnToHomePage();
   }
}
