package spkrash.krashinc.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase
{

   @Test
   public void testGroupCreation()
   {
      gotoGroupPage();
      initGroupCreation();
      fillGroupForm(new GroupData("testGroup1", "headerGr1", "footerGr1"));
      submitGroupCreation();
      returnToGroupPage();
   }

}
