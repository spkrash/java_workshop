package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

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
      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().selectGroup(1);
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testGroup1modified", "headerGr1modified", "footerGr1modified"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before);

   }
}
