package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().getGroupCount();
      app.getGroupHelper().groupCreationGrouped("testGroup1", "headerGr1", "footerGr1");
      int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after, before + 1);

   }
}
