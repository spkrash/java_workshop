package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.getNavigationHelper().gotoGroupPage();
      List<GroupData> before = app.getGroupHelper().getGroupList();
//      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      List<GroupData> after = app.getGroupHelper().getGroupList();
//      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after.size(), before.size() + 1);

   }
}
