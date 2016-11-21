package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.getNavigationHelper().gotoHomePage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getContactHelper().contactCreationGrouped("Bruce", "<B>", "Wayne", "Batman", "Gotham City", "+380500000000", "batman@gotham.com");
      }
   }

   @Test
   public void testContactModification()
   {
      List<ContactData> before = app.getContactHelper().getContactList();
      int index = 1;  // индекс элементов идёт с нулевого элемента по (before.size() - 1)
      ContactData contact = new ContactData("Bruce.2", "<B.2>", "Wayne.2", "Batman.2", "Gotham City.2", "+380511111111", "batman.2@gotham.com", before.get(index).getId());
      app.getContactHelper().modifyContact(index, contact);
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());;
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
   }
}
