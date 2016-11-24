package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

/**
 * Created by Krash on 24.11.2016.
 */
public class ContactInformationPageTests extends TestBase {


   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000"));
      }
   }
}
