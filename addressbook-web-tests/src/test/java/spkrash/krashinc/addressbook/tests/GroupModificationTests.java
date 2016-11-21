package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupModificationTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions(){
      app.getNavigationHelper().gotoGroupPage();
      if (!app.getGroupHelper().isElementPresent(By.name("selected[]"))) {
         app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      }
   }

   @Test
   public void testGroupModification()
   {
      List<GroupData> before = app.getGroupHelper().getGroupList();
      int index = before.size() - 1;
      GroupData group = new GroupData("testGroup1modified", "headerGr1modified", "footerGr1modified", before.get(index).getId());
      app.getGroupHelper().modifyGroup(index, group);
      List<GroupData> after = app.getGroupHelper().getGroupList();

      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
   }
}
