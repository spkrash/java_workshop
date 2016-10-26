package spkrash.krashinc.addressbook;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase
{

   @Test
   public void testGroupCreation()
   {
      gotoGroupPage();
      initGroupCreation();
      fillGroupForm(new GroupData("test1", "test2", "test3"));
      submitGroupCreation();
      returnToGroupPage();
   }

}
