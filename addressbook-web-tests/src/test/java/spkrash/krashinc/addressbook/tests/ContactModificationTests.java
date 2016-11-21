package spkrash.krashinc.addressbook.tests;

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
      app.goTo().homePage();
      if (app.contact().list().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
               .withMobileNum("+380500000000").withPersEmail("batman@gotham.com"));
      }
   }

   @Test
   public void testContactModification()
   {
      List<ContactData> before = app.contact().list();
      int index = 1;  // индекс элементов идёт с нулевого элемента по (before.size() - 1)
      ContactData contact = new ContactData().withFirstName("Bruce.2").withMiddleName("<B.2>").withLastName("Wayne.2").withNickname("Batman.2")
            .withAddress("Gotham City.2").withMobileNum("+380511111111").withPersEmail("batman.2@gotham.com").withId(before.get(index).getId());
      app.contact().modify(index, contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size());

      before.remove(index);
      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      ;
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
   }
}
