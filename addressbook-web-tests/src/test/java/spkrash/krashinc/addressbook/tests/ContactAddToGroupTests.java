package spkrash.krashinc.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;


/**
 * Created by Krash on 06.12.2016.
 */
public class ContactAddToGroupTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {

      if (app.db().contacts().size() == 0) {
         app.goTo().homePage();
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("(B)").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000"));
      }
      if (app.db().groups().size() == 0) {
         app.goTo().groupPage();
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testAddContactToGroup() {

      boolean success = false;

      for (ContactData contact : app.db().contacts()) {
         if (app.db().groups().size() != contact.getGroups().size()) {
            app.goTo().homePage();
            app.contact().selectContactById(contact.getId());
            for (GroupData group : app.db().groups()) {
               if (!group.getContacts().contains(contact)) {
                  app.contact().selectGroupForAdd(group.getId());
                  app.contact().addToSelectedGroup();
                  app.db().refresh(group);
                  assertTrue(group.getContacts().contains(contact));
                  return;
               }
            }
         }
      }
      app.goTo().homePage();
      app.contact().create(new ContactData()
            .withFirstName("Bruce").withMiddleName("(B)").withLastName("Wayne").withNickname("Batman")
            .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
            .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
            .withWorkPhone("+380600000000"));
      int currentContactId = app.db().contacts().stream().mapToInt((c) -> c.getId()).max().getAsInt();
      app.contact().selectContactById(currentContactId);
      GroupData group = app.db().groups().iterator().next();
      app.contact().selectGroupForAdd(group.getId());
      app.contact().addToSelectedGroup();
      app.db().refresh(group);
      for (ContactData contact : group.getContacts()) {
         if (contact.getId() == currentContactId) {
            success = true;
         }
      }
      assertTrue(success);
   }


}
