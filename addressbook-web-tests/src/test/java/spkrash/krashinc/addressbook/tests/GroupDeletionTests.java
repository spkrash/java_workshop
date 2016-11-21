package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Krash on 28.10.2016.
 */
public class GroupDeletionTests extends TestBase {

   @BeforeMethod
   public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().list().size() == 0) {
         app.group().create("testGroup1", "headerGr1", "footerGr1");
      }
   }

   @Test
   public void testGroupDeletion()
   {
      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      app.group().delete(index);
      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size() - 1);
      before.remove(index);
      Assert.assertEquals(before, after);

   }
}
