package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.Contacts;

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
      fillTextField(By.name("home"), contactData.getHomePhone());
      fillTextField(By.name("mobile"), contactData.getMobileNum());
      fillTextField(By.name("work"), contactData.getWorkPhone());
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

   public void initContactModification(int id)
   {
      clickItem(By.xpath("//td[@class='center'][input[@id='" + id + "']]/following-sibling::*[@class='center']//img[@title='Edit']"));
   }

   public void confirmContactModification()
   {
      clickItem(By.name("update"));
   }

   public void selectContact(int index)
   {
      wd.findElements(By.name("selected[]")).get(index).click();
   }

   public void selectContactById(int id)
   {
      wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
   }

   public void submitAlert()
   {
      wd.switchTo().alert().accept();
   }

   public void deleteContact()
   {
      clickItem(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
   }

   public void create(ContactData contact) {
      initContactCreation();
      fillContactForm(contact);
      confirmContactCreation();
      contactCash = null;
      returnToHomePage();
   }

   public void modify(ContactData contact) {
      initContactModification(contact.getId());
      fillContactForm(contact);
      confirmContactModification();
      contactCash = null;
      returnToHomePage();
   }

   public int count() {
      return wd.findElements(By.name("selected[]")).size();
   }

   private Contacts contactCash = null;

   public Contacts all() {
      if (contactCash != null) {
         return new Contacts(contactCash);
      }
      contactCash = new Contacts();
      List<WebElement> elements = wd.findElements(By.name("selected[]"));
      for (int i = 2; i < elements.size() + 2; i++) {
         String firstName = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[3]")).getText();
         String lastName = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[2]")).getText();
         String address = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[4]")).getText();
         int id = Integer.parseInt(wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[" + i + "]/td[1]/input")).getAttribute("value"));
         contactCash.add(new ContactData().withFirstName(firstName).withLastName(lastName).withAddress(address).withId(id));
      }
      return new Contacts(contactCash);
   }

   public boolean isThereAContact() {
      return isElementPresent(By.name("selected[]"));
   }

   public void delete(ContactData contact) {
      selectContactById(contact.getId());
      deleteContact();
      contactCash = null;
      submitAlert();
   }

   public ContactData infoFromEditForm(ContactData contact) {
      initContactModification(contact.getId());
      String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
      String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
      String address = wd.findElement(By.name("address")).getAttribute("value");
      String home = wd.findElement(By.name("home")).getAttribute("value");
      String work = wd.findElement(By.name("work")).getAttribute("value");
      String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
      String email = wd.findElement(By.name("email")).getAttribute("value");
      wd.navigate().back();
      return new ContactData().withId(contact.getId()).withFirstName(firstname)
            .withLastName(lastname).withAddress(address).withHomePhone(home)
            .withWorkPhone(work).withMobileNum(mobile).withPersEmail(email);

   }
}

