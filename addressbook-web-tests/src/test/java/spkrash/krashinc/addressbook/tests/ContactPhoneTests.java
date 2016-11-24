package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 23.11.2016.
 */
public class ContactPhoneTests extends TestBase {

   @Test
   public void testContactPhones() {
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
      assertThat(contact.getAllPhones(), equalTo(mergePhone(contactInfoFromEditForm)));
   }

   private String mergePhone(ContactData contact) {
      return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getHomePhone2())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
   }

   public static String cleaned(String phone){
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
   }
}
