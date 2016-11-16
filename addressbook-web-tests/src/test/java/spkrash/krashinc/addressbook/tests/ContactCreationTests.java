package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.getNavigationHelper().gotoHomePage();
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().contactCreationGrouped("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com");
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before + 1);

   }
}
