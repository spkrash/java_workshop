package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.Set;

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
      Set<GroupData> before = app.group().all();
      GroupData modifiedGroup = before.iterator().next();
      GroupData group = new GroupData()
            .withName("testGroupModified").withHeader("headerGrModified").withFooter("footerGrModified").withId(modifiedGroup.getId());
      app.group().modify(group);
      Set<GroupData> after = app.group().all();

      before.remove(modifiedGroup);
      before.add(group);
      Assert.assertEquals(before, after);
   }
}
