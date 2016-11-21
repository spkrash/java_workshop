package spkrash.krashinc.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.goTo().groupPage();
      Set<GroupData> before = app.group().all();
      GroupData group = new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1");
      app.group().create(group);
      Set<GroupData> after = app.group().all();
      Assert.assertEquals(after.size(), before.size() + 1);

      group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
      before.add(group);
      Assert.assertEquals(before, after);
   }
}
