package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import spkrash.krashinc.addressbook.model.ContactData;

/**
 * Created by Krash on 27.10.2016.
 */
public class ContactHelper extends HelperBase
{

   public ContactHelper(FirefoxDriver wd)
   {
      super(wd);
   }

   public void fillContactForm(ContactData contactData)
   {
      fillTextField(By.name("firstname"), contactData.getFirstName());
      fillTextField(By.name("middlename"), contactData.getMiddleName());
      fillTextField(By.name("lastname"), contactData.getLastName());
      fillTextField(By.name("nickname"), contactData.getNickname());
      fillTextField(By.name("address"), contactData.getAddress());
      fillTextField(By.name("mobile"), contactData.getMobileNum());
      fillTextField(By.name("email"), contactData.getPersEmail());
   }

   public void returnToHomePage()
   {
      clickItem(By.linkText("home page"));
   }

   public void confirmContactCreation()
   {
      clickItem(By.xpath("//div[@id='content']/form/input[21]"));
   }

   public void initContactCreation()
   {
      clickItem(By.linkText("add new"));
   }
}
