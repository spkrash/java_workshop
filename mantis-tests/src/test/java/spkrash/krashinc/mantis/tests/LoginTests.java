package spkrash.krashinc.mantis.tests;


import org.testng.annotations.Test;
import spkrash.krashinc.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Krash on 11.12.2016.
 */
public class LoginTests extends TestBase {

   @Test
   public void testLogin() throws IOException {
      HttpSession session = app.newSession();
      assertTrue(session.login("administrator", "root"));
      assertTrue(session.isLoggedInAs("administrator"));
   }
}
