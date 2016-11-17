package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupModificationTests extends TestBase {
   @Test
   public void testGroupModification()
   {
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size()-1);
      app.getGroupHelper().initGroupModification();
      GroupData group = new GroupData("testGroup1modified", "headerGr1modified", "footerGr1modified", before.get(before.size()-1).getId());
      app.getGroupHelper().fillGroupForm(group);
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      List<GroupData> after = app.getGroupHelper().getGroupList();

      before.remove(before.size()-1);
      before.add(group);
      Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
   }
}
