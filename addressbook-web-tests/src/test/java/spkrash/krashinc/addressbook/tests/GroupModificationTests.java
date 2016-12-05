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
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      if (app.db().groups().size() == 0){
         app.goTo().groupPage();
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testGroupModification()
   {
      Groups before = app.db().groups();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
            .withName("testGroupModified").withHeader("headerGrModified").withFooter("footerGrModified").withId(modifiedGroup.getId());
      app.goTo().groupPage();
      app.group().modify(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
   }
}
