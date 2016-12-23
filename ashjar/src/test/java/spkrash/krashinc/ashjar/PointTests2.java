package spkrash.krashinc.ashjar;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Krash on 24.10.2016.
 */
public class PointTests2
{
   @Test
   public void testDist()
   {
      // позитивный тест
      Point p1 = new Point(7, 12);
      Point p2 = new Point(4, 8);
      Assert.assertEquals(distance(p1, p2), 5.0);
   }

   public static double distance(Point p1, Point p2)
   {
      return Math.sqrt((p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y));
   }


   @Test
   public void testDist2()
   {
      // несовпадение типов
      Point p1 = new Point(7, 12);
      Point p2 = new Point(4, 8);
      Assert.assertEquals(distance(p1, p2), 5);
   }

   @Test
   public void testDist3()
   {
      // ошибка в ожидаемом ррезультате
      Point p1 = new Point(7, 12);
      Point p2 = new Point(4, 8);
      Assert.assertEquals(distance(p1, p2), 4.0);
   }

}
