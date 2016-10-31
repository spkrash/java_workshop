package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().initGroupCreation();
      app.getGroupHelper().fillGroupForm(new GroupData("testGroup1", "headerGr1", "footerGr1"));
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returnToGroupPage();
   }

}
