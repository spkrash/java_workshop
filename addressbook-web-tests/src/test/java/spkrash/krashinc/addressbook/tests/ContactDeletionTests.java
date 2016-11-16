package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactDeletionTests extends TestBase {
   @Test
   public void testContactDeletion()
   {
      app.getNavigationHelper().gotoHomePage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getContactHelper().contactCreationGrouped("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com");
      }
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().submitAlert();
      app.getNavigationHelper().gotoHomePage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before - 1);
   }
}
