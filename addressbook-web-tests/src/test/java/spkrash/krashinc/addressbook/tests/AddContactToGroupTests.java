package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import java.io.File;

/**
 * Created by Krash on 06.12.2016.
 */
public class AddContactToGroupTests extends TestBase {

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
      if (app.db().groups().size() == 0) {
         app.goTo().groupPage();
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testAddContactToGroup() {

      Groups groupsList = app.db().groups();

      for (ContactData contact : app.db().contacts()) {
         if (groupsList.size() != contact.getGroups().size()) {
            app.goTo().homePage();
            app.contact().selectContactById(contact.getId());
            String groupName = "";
            for (GroupData group : app.db().groups()) {
               if (!group.getContacts().contains(contact)) {
                  groupName = group.getName();
                  break;
               }
            }
            app.contact().selectGroupForAdd(groupName);
            app.contact().addToSelectedGroup();
         }
      } else {
         app.goTo().homePage();
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("(B)").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000").withPhoto(new File("src/test/resources/avatar.png")));
         app.contact().selectContactById(app.db().contacts().stream().mapToInt((c) -> c.getId()).max().getAsInt());
         app.contact().addToSelectedGroup();
      }
   }


}
