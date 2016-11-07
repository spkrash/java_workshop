package spkrash.krashinc.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteGroup();
      app.getGroupHelper().returnToGroupPage();
   }
}
