package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
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
         app.getGroupHelper().initGroupCreation();
         app.getGroupHelper().fillGroupForm(new GroupData("testGroup1", "headerGr1", "footerGr1"));
         app.getGroupHelper().submitGroupCreation();
         app.getGroupHelper().returnToGroupPage();
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testGroup1modified", "headerGr1modified", "footerGr1modified"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
   }
}
