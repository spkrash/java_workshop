package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.goTo().homePage();
      List<ContactData> before = app.contact().list();
      ContactData contact = new ContactData()
            .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
            .withMobileNum("+380500000000").withPersEmail("batman@gotham.com");
      app.contact().create(contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      ;
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

   }
}
