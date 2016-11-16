package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupDeletionTests extends TestBase {
   @Test
   public void testGroupDeletion()
   {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
//      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().selectGroup(before.size() - 1);
      app.getGroupHelper().deleteGroup();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();
//      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after.size(), before.size() - 1);

   }
}
