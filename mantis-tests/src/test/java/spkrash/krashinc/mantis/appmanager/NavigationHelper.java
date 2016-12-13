package spkrash.krashinc.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Krash on 26.10.2016.
 */
public class NavigationHelper extends HelperBase {

   public NavigationHelper(ApplicationManager app) {
      super(app);
   }

   public void settings() {
      if (isElementPresent(By.id("manage-overview-table"))) {
         return;
      }
      clickItem(By.cssSelector("a[href$='manage_overview_page.php']"));
   }

   public void userSettings() {
      if (isElementPresent(By.id("manage-user-div"))) {
         return;
      }
      clickItem(By.cssSelector("a[href$='manage_user_page.php']"));
   }
}
