package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactDeletionTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
         app.contact().create(new ContactData()
               .withFirstName("Bruce").withMiddleName("<B>").withLastName("Wayne").withNickname("Batman").withAddress("Gotham City")
               .withMobileNum("+380500000000").withPersEmail("batman@gotham.com"));
      }
   }

   @Test
   public void testContactDeletion()
   {
      Set<ContactData> before = app.contact().all();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      app.goTo().homePage();
      Set<ContactData> after = app.contact().all();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedContact);
      Assert.assertEquals(before, after);
   }
}
