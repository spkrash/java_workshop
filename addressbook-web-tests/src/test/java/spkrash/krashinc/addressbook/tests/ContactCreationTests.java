package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
   @Test
   public void testContactCreation()
   {
      app.goTo().homePage();
      Contacts before = app.contact().all();
      File photo = new File("src/test/resources/avatar.png");
      ContactData contact = new ContactData()
            .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman")
            .withAddress("Gotham City").withMobileNum("+380500000000").withEmail("batman@gotham.com")
            .withHomePhone("+380400000000").withWorkPhone("+380600000000").withEmail2("batman2@gotham.com")
            .withEmail3("batman3@gotham.com").withPhoto(photo);
      app.contact().create(contact);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Set<ContactData> after = app.contact().all();
      assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
   }

   @Test (enabled = false)
   public void testCurrentDir(){
      File currentDir = new File(".");
      System.out.println(currentDir.getAbsolutePath());
      File photo = new File("src/test/resources/avatar.png");
      System.out.println(photo.getAbsolutePath());
      System.out.println(photo.exists());

   }

}
