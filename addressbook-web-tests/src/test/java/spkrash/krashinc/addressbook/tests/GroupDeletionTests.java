package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupDeletionTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testGroupDeletion()
   {
      Groups before = app.group().all();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      Groups after = app.group().all();
      assertEquals(after.size(), before.size() - 1);
      assertThat(after, equalTo(before.withOut(deletedGroup)));
   }
}
