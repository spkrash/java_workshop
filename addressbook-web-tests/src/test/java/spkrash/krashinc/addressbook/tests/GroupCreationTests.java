package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
   }
}
