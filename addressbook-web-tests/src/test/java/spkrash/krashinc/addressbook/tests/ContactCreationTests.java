package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.goTo().homePage();
      Set<ContactData> before = app.contact().all();
      ContactData contact = new ContactData()
            .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
            .withMobileNum("+380500000000").withPersEmail("batman@gotham.com");
      app.contact().create(contact);
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
      before.add(contact);
      Assert.assertEquals(before, after);

   }
}
