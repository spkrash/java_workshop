package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.List;

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
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size()-1);
      app.getContactHelper().deleteContact();
      app.getContactHelper().submitAlert();
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
   }
}
