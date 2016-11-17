package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
      GroupData group = new GroupData("testGroup1", "headerGr1", "footerGr1");
      app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size() + 1);

      int max = 0;
      for (GroupData g : after){
         if (g.getId() > max){
            max = g.getId();
         }
      }
      group.setId(max);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

   }
}
