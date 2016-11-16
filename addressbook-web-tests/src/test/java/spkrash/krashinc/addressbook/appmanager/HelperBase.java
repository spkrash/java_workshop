package spkrash.krashinc.addressbook.appmanager;

import org.openqa.selenium.*;

/**
 * Created by Krash on 28.10.2016.
 */
public class HelperBase {
   protected WebDriver wd;

   public HelperBase(WebDriver wd)
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
      if (text != null) {
         String existingText = element.getAttribute("value");
         if (!text.equals(existingText)) {
            element.clear();
            element.sendKeys(text);
         }
      }
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

   public boolean isElementPresent(By locator) {
      try {
         wd.findElement(locator);
         return true;
      } catch (NoSuchElementException ex) {
         return false;
      }
   }
}
