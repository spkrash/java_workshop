package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Krash on 24.11.2016.
 */
public class ContactInformationPageTests extends TestBase {


   public static String simplified(String phone) {
      return phone.replaceAll("\n", "");
   }

   @BeforeMethod
   public void ensurePreconditions() {
      if (app.db().contacts().size() == 0) {
         app.goTo().homePage();
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("(B)").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000").withPhoto(new File("src/test/resources/avatar.png")));
      }
   }

   @Test

   public void testContactInformationPage() {
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      System.out.println(contactInfoFromEditForm);
      app.goTo().contactInfoById(contact.getId());
      assertThat(simplified(app.contact().infoFromInfoPage()), equalTo(simplified(mergedFromEditForInfo(contactInfoFromEditForm))));
   }

   private String mergedFromEditForInfo(ContactData contactInfoFromEditForm) {

      String result = contactInfoFromEditForm.getFirstName();

      if (!"".equals(contactInfoFromEditForm.getFirstName()) && !"".equals(contactInfoFromEditForm.getMiddleName())) {
         result = result + " ";
      }

      result = result + contactInfoFromEditForm.getMiddleName();

      if (!"".equals(result) && !"".equals(contactInfoFromEditForm.getLastName())) {
         result = result + " ";
      }

      result = result + contactInfoFromEditForm.getLastName() + contactInfoFromEditForm.getNickname() + contactInfoFromEditForm.getAddress();

      if (!"".equals(contactInfoFromEditForm.getHomePhone())) {
         result = result + "H: " + contactInfoFromEditForm.getHomePhone();
      }

      if (!"".equals(contactInfoFromEditForm.getMobilePhone())) {
         result = result + "M: " + contactInfoFromEditForm.getMobilePhone();
      }

      if (!"".equals(contactInfoFromEditForm.getWorkPhone())) {
         result = result + "W: " + contactInfoFromEditForm.getWorkPhone();
      }

      result = result + contactInfoFromEditForm.getEmail() + contactInfoFromEditForm.getEmail2() + contactInfoFromEditForm.getEmail3();

      if (!"".equals(contactInfoFromEditForm.getHomePhone2())) {
         result = result + "P: " + contactInfoFromEditForm.getHomePhone2();
      }

      return result;
   }
}
