package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      ContactData contact = new ContactData()
            .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman")
            .withAddress("Gotham City").withMobileNum("+380500000000").withPersEmail("batman@gotham.com");
      app.contact().create(contact);
      Set<ContactData> after = app.contact().all();
      assertThat(after.size(), equalTo(before.size() + 1));

      assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
   }
}
