package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import java.util.List;

/**
 * Created by Krash on 26.10.2016.
 */
public class GroupHelper extends HelperBase {

   private Groups groupCash = null;

   public GroupHelper(WebDriver wd)
   {
      super(wd);
   }

   public void returnToGroupPage()
   {
      clickItem(By.linkText("group page"));
   }

   public void submitGroupCreation()
   {
      clickItem(By.name("submit"));
   }

   public void fillGroupForm(GroupData groupData)
   {
      fillTextField(By.name("group_name"), groupData.getName());
      fillTextField(By.name("group_header"), groupData.getHeader());
      fillTextField(By.name("group_footer"), groupData.getFooter());
   }

   public void initGroupCreation()
   {
      clickItem(By.name("new"));
   }

   public void selectGroupById(int id) {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
   }

   public void deleteGroup()
   {
      clickItem(By.name("delete"));
   }

   public void initGroupModification()
   {
      clickItem(By.name("edit"));
   }

   public void submitGroupModification()
   {
      clickItem(By.name("update"));
   }

   public void create(GroupData group) {
      initGroupCreation();
      fillGroupForm(group);
      submitGroupCreation();
      groupCash = null;
      returnToGroupPage();
   }

   public boolean isThereAGroup() {
      return isElementPresent(By.name("selected[]"));
   }

   public int count() {
      return wd.findElements(By.name("selected[]")).size();
   }

   public void modify(GroupData group) {
      selectGroupById(group.getId());
      initGroupModification();
      fillGroupForm(group);
      submitGroupModification();
      groupCash = null;
      returnToGroupPage();
   }

   public Groups all() {
      if (groupCash != null) {
         return new Groups(groupCash);
      }
      groupCash = new Groups();
      List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
      for (WebElement element : elements) {
         String name = element.getText();
         int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
         groupCash.add(new GroupData().withName(name).withId(id));
      }
      return new Groups(groupCash);
   }

   public void delete(GroupData group) {
      selectGroupById(group.getId());
      deleteGroup();
      groupCash = null;
      returnToGroupPage();
   }
}
