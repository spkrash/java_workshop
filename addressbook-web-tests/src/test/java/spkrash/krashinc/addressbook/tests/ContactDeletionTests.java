package spkrash.krashinc.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Krash on 28.10.2016.
 */
public class ContactDeletionTests extends TestBase
{
   @Test
   public void testContactDeletion()
   {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().selectContact();
      app.getContactHelper().deleteContact();
      app.getContactHelper().submitAlert();
      app.getNavigationHelper().gotoHomePage();
   }
}
