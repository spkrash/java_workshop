package spkrash.krashinc.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Krash on 11.12.2016.
 */
public class RegistrationTests extends TestBase {

   @Test
   public void testRegistration(){
      app.registration().start("user1", "user1@localhost.localdomain");
   }
}
