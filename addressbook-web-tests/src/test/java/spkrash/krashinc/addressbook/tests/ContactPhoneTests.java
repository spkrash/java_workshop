package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

/**
 * Created by Krash on 23.11.2016.
 */
public class ContactPhoneTests extends TestBase {

   @Test (enabled = false)
   public void testContactPhones() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
               .withMobileNum("+380500000000").withPersEmail("batman@gotham.com").withHomePhone("+380400000000").withWorkPhone("+380600000000"));
      }
   }
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
   }

