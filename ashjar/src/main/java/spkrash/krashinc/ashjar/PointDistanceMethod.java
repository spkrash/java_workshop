package spkrash.krashinc.ashjar;

/**
 * Created by Krash on 19.10.2016.
 * класс для описания и создания двух точек с заданными координатами и методом для вычисления расстояния между ними
 */
public class PointDistanceMethod
{
   public int x1;
   public int x2;
   public int y1;
   public int y2;

   public PointDistanceMethod(int x1, int x2, int y1, int y2)
   {
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
   }
   public double distance()
   {
      return Math.sqrt(Math.pow(this.x1 - this.x2, 2) + Math.pow(this.y1 - this.y2, 2));
   }
}
