package spkrash.krashinc.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase
{
   @Test
   public void testContactCreation()
   {
      gotoHomePage();
      initContactCreation();
      fillContactForm(new ContactData("Bruce", "B", "Wayne", "Batman", "Gotham City", "+38050000000", "batman@gotham.com"));
      confirmContactCreation();
      returnToHomePage();
   }
}
