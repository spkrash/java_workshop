package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;
import spkrash.krashinc.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 07.12.2016.
 */
public class ContactRemoveFromGroupTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().homePage();
      if (app.db().contacts().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("(B)").withLastName("Wayne").withNickname("Batman")
               .withAddress("Gotham City").withEmail("batman@gotham.com").withEmail2("batman2@gotham.com")
               .withEmail3("batman3@gotham.com").withMobileNum("+380500000000").withHomePhone("+380400000000")
               .withWorkPhone("+380600000000"));
      }
      if (app.db().groups().size() == 0) {
         app.goTo().groupPage();
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
         app.goTo().homePage();
      }
   }

   @Test
   public void testRemoveContactFromGroup() {
      for (GroupData group : app.db().groups()) {
         if (!group.getContacts().isEmpty()) {
            Contacts before = group.getContacts();
            app.contact().selectGroupView(group.getId());
            ContactData removedContact = before.iterator().next();
            app.contact().selectContactById(removedContact.getId());
            app.contact().removeSelectedContactsFromGroup();
            app.goTo().homePage();
            app.db().refresh(group);
            Contacts after = group.getContacts();
            assertThat(after, equalTo(before.withOut(removedContact)));
            return;
         }
      }
      ContactData contactInTest = app.db().contacts().iterator().next();
      app.contact().selectContactById(contactInTest.getId());
      GroupData group = app.db().groups().iterator().next();
      app.contact().selectGroupForAdd(group.getId());
      app.contact().addToSelectedGroup();
      app.goTo().homePage();
      app.db().refresh(group);
      assertThat(group.getContacts().size(), equalTo(1));
      app.contact().selectGroupView(group.getId());
      app.contact().selectContactById(contactInTest.getId());
      app.contact().removeSelectedContactsFromGroup();
      app.goTo().homePage();
      app.db().refresh(group);
      assertThat(group.getContacts().size(), equalTo(0));
   }

}
