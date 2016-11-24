package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 24.11.2016.
 */
public class ContactEmailsTests extends TestBase {

   @Test
   public void testContactEmails() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000"));
      }
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
   }

   private String mergeEmails(ContactData contact) {
      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals("")).map(ContactEmailsTests::cleaned).collect(Collectors.joining("\n"));
   }

   public static String cleaned(String phone) {
      return phone.replaceAll("\\s", "");
   }

}
