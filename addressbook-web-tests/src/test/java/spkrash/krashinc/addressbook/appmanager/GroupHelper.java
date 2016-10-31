package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import spkrash.krashinc.addressbook.model.GroupData;

/**
 * Created by Krash on 26.10.2016.
 */
public class GroupHelper extends HelperBase {

   public GroupHelper(FirefoxDriver wd)
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

   public void selectGroup()
   {
      clickItem(By.name("selected[]"));
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
}
