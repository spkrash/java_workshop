package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation()
   {
      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("testGroup1").withHeader("headerGr1").withFooter("footerGr1");
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
   }

   @Test
   public void testBadGroupCreation()
   {
      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("testGroup1'").withHeader("headerGr1").withFooter("footerGr1");
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.group().all();
      assertThat(after, equalTo(before));
   }}
