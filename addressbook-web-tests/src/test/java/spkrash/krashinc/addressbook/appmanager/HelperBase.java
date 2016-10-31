package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Krash on 28.10.2016.
 */
public class HelperBase {
   protected FirefoxDriver wd;

   public HelperBase(FirefoxDriver wd)
   {
      this.wd = wd;
   }

   protected void clickItem(By locator)
   {
      wd.findElement(locator).click();
   }

   protected void fillTextField(By locator, String text)
   {
      WebElement element = wd.findElement(locator);
      element.clear();
      element.sendKeys(text);
   }

   public boolean isAlertPresent()
   {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

}
