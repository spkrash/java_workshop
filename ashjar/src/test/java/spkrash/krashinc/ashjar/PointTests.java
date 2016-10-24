package spkrash.krashinc.ashjar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Krash on 24.10.2016.
 */
public class PointTests
{
   @Test
   public void testDist()
   {
      // позитивный тест
      PointDistanceMethod dist = new PointDistanceMethod(7, 4, -3, 1);
      Assert.assertEquals(dist.distance(), 5.0);
   }

   @Test
   public void testDist2()
   {
      // несовпадение типов
      PointDistanceMethod dist = new PointDistanceMethod(7, 4, -3, 1);
      Assert.assertEquals(dist.distance(), 5);
   }

   @Test
   public void testDist3()
   {
      // ошибка в ожидаемом ррезультате
      PointDistanceMethod dist = new PointDistanceMethod(7, 4, -3, 1);
      Assert.assertEquals(dist.distance(), 4.0);
   }
}
