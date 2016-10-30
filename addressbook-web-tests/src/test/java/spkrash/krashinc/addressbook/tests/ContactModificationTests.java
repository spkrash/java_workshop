package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactModificationTests extends TestBase
{
   @Test
   public void testContactModification()
   {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().initContactModification();
      app.getContactHelper().fillContactForm(new ContactData("Bruce.2", "<B.2>", "Wayne.2", "Batman.2", "Gotham City.2", "+380511111111", "batman.2@gotham.com"));
      app.getContactHelper().confirmContactModification();
      app.getContactHelper().returnToHomePage();
   }
}
