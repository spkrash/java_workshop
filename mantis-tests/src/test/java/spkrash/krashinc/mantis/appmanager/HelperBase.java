package spkrash.krashinc.mantis.appmanager;

import org.openqa.selenium.*;

import java.io.File;

/**
 * Created by Krash on 28.10.2016.
 */
public class HelperBase {

   protected ApplicationManager app;
   protected WebDriver wd;

   public HelperBase(ApplicationManager app)
   {
      this.app = app;
      this.wd = app.getDriver();
   }

   protected void clickItem(By locator)
   {
      wd.findElement(locator).click();
   }

   protected void fillTextField(By locator, String text)
   {
      WebElement element = wd.findElement(locator);
      clickItem(locator);
      if (text != null) {
         String existingText = element.getAttribute("value");
         if (!text.equals(existingText)) {
            element.clear();
            element.sendKeys(text);
         }
      }
   }

   protected void attach(By locator, File file)
   {
      if (file != null) {
         wd.findElement(locator).sendKeys(file.getAbsolutePath());
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
