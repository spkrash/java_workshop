package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;

import java.io.File;

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
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000").withPhoto(new File("src/test/resources/avatar.png")));
      }
   }

   @Test
   public void testContactModification()
   {
      Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
      ContactData contact = new ContactData().withFirstName("Bruce.2").withMiddleName("<B.2>")
            .withLastName("Wayne.2").withNickname("Batman.2").withAddress("Gotham City.2")
            .withMobileNum("+380511111111").withHomePhone("+380411111111").withWorkPhone("+380611111111")
            .withId(modifiedContact.getId()).withEmail("batman.2@gotham.com").withEmail2("batman2.2@gotham.com")
            .withEmail3("batman3.2@gotham.com");
      app.contact().modify(contact);
      assertThat(app.contact().count(), equalTo(before.size()));
      Contacts after = app.contact().all();
      assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
   }
}
