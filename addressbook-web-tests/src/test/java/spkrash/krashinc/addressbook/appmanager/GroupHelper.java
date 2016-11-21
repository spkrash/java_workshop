package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krash on 26.10.2016.
 */
public class GroupHelper extends HelperBase {

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

   public void selectGroup(int index)
   {
      wd.findElements(By.name("selected[]")).get(index).click();
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
      returnToGroupPage();
   }

   public void modify(int index, GroupData group) {
      selectGroup(index);
      initGroupModification();
      fillGroupForm(group);
      submitGroupModification();
      returnToGroupPage();
   }

   public int getGroupCount() {
      return wd.findElements(By.name("selected[]")).size();
   }

   public List<GroupData> list() {
      List<GroupData> groups = new ArrayList<>();
      List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
      for (WebElement element : elements) {
         String name = element.getText();
         int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
         groups.add(new GroupData().withName(name).withId(id));
      }
      return groups;
   }

   public boolean isThereAGroup() {
      return isElementPresent(By.name("selected[]"));
   }

   public void delete(int index) {
      selectGroup(index);
      deleteGroup();
      returnToGroupPage();
   }

}
