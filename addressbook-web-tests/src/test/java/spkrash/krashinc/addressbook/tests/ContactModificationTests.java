package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactModificationTests extends TestBase {
   @Test
   public void testContactModification()
   {
      app.getNavigationHelper().gotoHomePage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getContactHelper().contactCreationGrouped("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com");
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().initContactModification(1); // индекс элементов идёт с нулевого элемента по (before.size() - 1)
      app.getContactHelper().fillContactForm(new ContactData("Bruce.2", "<B.2>", "Wayne.2", "Batman.2", "Gotham City.2", "+380511111111", "batman.2@gotham.com"));
      app.getContactHelper().confirmContactModification();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());
   }
}
