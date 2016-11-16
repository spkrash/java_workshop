package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import spkrash.krashinc.addressbook.model.GroupData;

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

   public void groupCreationGrouped(String name, String header, String footer) {
      initGroupCreation();
      fillGroupForm(new GroupData(name, header, footer));
      submitGroupCreation();
      returnToGroupPage();
   }

   public int getGroupCount() {
      return wd.findElements(By.name("selected[]")).size();
   }
}
