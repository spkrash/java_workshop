package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupDeletionTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.db().groups().size() == 0){
         app.goTo().groupPage();
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testGroupDeletion()
   {
      Groups before = app.db().groups();
      GroupData deletedGroup = before.iterator().next();
      app.goTo().groupPage();
      app.group().delete(deletedGroup);
      assertThat(app.group().count(), equalTo(before.size() - 1));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.withOut(deletedGroup)));
      verifyGroupListInUI();
   }
}
