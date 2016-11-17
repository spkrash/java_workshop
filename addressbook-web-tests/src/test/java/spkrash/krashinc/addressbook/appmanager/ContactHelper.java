package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.css.Rect;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krash on 27.10.2016.
 */
public class ContactHelper extends HelperBase {

   public ContactHelper(WebDriver wd)
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

   public void initContactModification(int index)
   {
      clickItem(By.xpath("//table[@id='maintable']/tbody/tr[" + (index + 2) + "]/td[8]/a/img"));
   }

   public void confirmContactModification()
   {
      clickItem(By.name("update"));
   }

   public void selectContact(int index)
   {
      wd.findElements(By.name("selected[]")).get(index).click();
   }

   public void submitAlert()
   {
      wd.switchTo().alert().accept();
   }

   public void deleteContact()
   {
      clickItem(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
   }

   public void contactCreationGrouped(String firstName, String middleName, String lastName, String nickname, String address, String mobileNum, String persEmail) {
      initContactCreation();
      fillContactForm(new ContactData(firstName, middleName, lastName, nickname, address, mobileNum, persEmail));
      confirmContactCreation();
      returnToHomePage();
   }

   public int getContactCount() {
      return wd.findElements(By.name("selected[]")).size();
   }

   public List<ContactData> getContactList() {
      List<ContactData> contacts = new ArrayList<>();
      List<WebElement> elements = wd.findElements(By.name("selected[]"));
      for (int i = 0; i < elements.size(); i++){
         String firstName = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + (i + 2) + "]/td[3]")).getText();
         String lastName = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + (i + 2) + "]/td[2]")).getText();
         String address = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + (i + 2) + "]/td[4]")).getText();
         String id = wd.findElement(By.name("selected[]")).getAttribute("value");
         ContactData contact = new ContactData(firstName, null, lastName, null, address, null, null, id);
         contacts.add(contact);
      }
      return contacts;

   }
}
