package spkrash.krashinc.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTests
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

   @BeforeMethod
   public void setUp() throws Exception
   {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/edit.php");
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

   @Test
   public void testContactCreation()
   {

      wd.findElement(By.linkText("home")).click();
      wd.findElement(By.linkText("add new")).click();
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys("Sergii");
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys("V.");
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys("Pavlenko");
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys("Krash");
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys("Kyiv, Ukraine");
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys("+38050000000");
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys("spkrash@gmail.com");
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
      wd.findElement(By.linkText("home page")).click();
   }

   @AfterMethod
   public void tearDown()
   {
      wd.quit();
   }
}