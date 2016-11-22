package spkrash.krashinc.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
         app.group().create(new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1"));
      }
   }

   @Test
   public void testGroupModification()
   {
      Groups before = app.group().all();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
            .withName("testGroupModified").withHeader("headerGrModified").withFooter("footerGrModified").withId(modifiedGroup.getId());
      app.group().modify(group);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size()));
      assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
   }
}
