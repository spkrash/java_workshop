package spkrash.krashinc.addressbook.tests;

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
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("testGroup1modified", "headerGr1modified", "footerGr1modified"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
   }
}
