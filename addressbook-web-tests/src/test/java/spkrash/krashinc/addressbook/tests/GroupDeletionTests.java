package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupDeletionTests extends TestBase
{
   @Test
   public void testGroupDeletion()
   {
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteGroup();
      app.getGroupHelper().returnToGroupPage();
   }

}
