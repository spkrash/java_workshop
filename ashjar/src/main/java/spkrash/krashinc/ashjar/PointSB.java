package spkrash.krashinc.ashjar;

/**
 * Created by Krash on 24.12.2016.
 * Point Strikes Back
 */
public class PointSB {
   public double x;
   public double y;

   public PointSB(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public double distance(PointSB p2){
      return Math.sqrt((this.x- p2.x) * (this.x- p2.x) + (this.y- p2.y) * (this.y- p2.y));
   }
}
