package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
               .withMobileNum("+380500000000").withPersEmail("batman@gotham.com"));
      }
   }

   @Test
   public void testContactModification()
   {
      Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData().withFirstName("Bruce.2").withMiddleName("<B.2>")
            .withLastName("Wayne.2").withNickname("Batman.2").withAddress("Gotham City.2")
            .withMobileNum("+380511111111").withPersEmail("batman.2@gotham.com")
            .withId(modifiedContact.getId());
      app.contact().modify(contact);
      assertThat(app.contact().count(), equalTo(before.size()));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
   }
}
