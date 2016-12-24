package spkrash.krashinc.ashjar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Krash on 24.12.2016.
 * Point Test Strikes Back
 */
public class PointTestSB {
   @Test
   public void testDist()
   {
      // позитивный тест
      PointSB p1 = new PointSB(7, 12);
      PointSB p2 = new PointSB(4, 8);
      Assert.assertEquals(p1.distance(p2), 5.0);
   }

}
