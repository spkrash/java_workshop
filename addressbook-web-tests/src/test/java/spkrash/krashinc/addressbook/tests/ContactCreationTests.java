package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().contactCreationGrouped("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com");
   }
}
