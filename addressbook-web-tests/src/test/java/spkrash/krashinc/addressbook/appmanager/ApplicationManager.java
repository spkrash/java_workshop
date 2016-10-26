package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

/**
 * Created by Krash on 26.10.2016.
 */
public class ApplicationManager
{
   FirefoxDriver wd;

   public static boolean isAlertPresent(FirefoxDriver wd)
   {
      try
      {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e)
      {
         return false;
      }
   }

   public void init()
   {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      login("admin", "secret");
   }

   private void login(String username, String password)
   {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
   }

   public void returnToGroupPage()
   {
      wd.findElement(By.linkText("group page")).click();
   }

   public void submitGroupCreation()
   {
      wd.findElement(By.name("submit")).click();
   }

   public void fillGroupForm(GroupData groupData)
   {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
   }

   public void initGroupCreation()
   {
      wd.findElement(By.name("new")).click();
   }

   public void gotoGroupPage()
   {
      wd.findElement(By.linkText("groups")).click();
   }

   public void stop()
   {
      wd.quit();
   }

   public void fillContactForm(ContactData contactData)
   {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobileNum());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getPersEmail());
   }

   public void returnToHomePage()
   {
      wd.findElement(By.linkText("home page")).click();
   }

   public void confirmContactCreation()
   {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
   }

   public void initContactCreation()
   {
      wd.findElement(By.linkText("add new")).click();
   }

   public void gotoHomePage()
   {
      wd.findElement(By.linkText("home")).click();
   }
}
