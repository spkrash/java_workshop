package spkrash.krashinc.ashjar;

public class HelloWorld {
   public static void main(String[] args)
   {
      hello("Алексей");

      // через функцию
      Point p1 = new Point(7, 12);
      Point p2 = new Point(4, 8);
      System.out.println("Первая точка имеет координаты (" + p1.x + ";" + p1.y + ").");
      System.out.println("Вторая точка имеет координаты (" + p2.x + ";" + p2.y + ").");
      System.out.println("Расстояние между точками равно " + distance(p1, p2) + "." + "\n");

      // через метод
      PointDistanceMethod dist = new PointDistanceMethod(7, 4, -3, 1);
      System.out.println("Первая точка имеет координаты (" + dist.x1 + ";" + dist.y1 + ").");
      System.out.println("Вторая точка имеет координаты (" + dist.x2 + ";" + dist.y2 + ").");
      System.out.println("Расстояние между точками равно " + dist.distance() + ".");

      tezzt();

   }

   public static void hello(String target)
   {
      System.out.println("Привет, " + target + "!" + "\n");
   }

   public static double distance(Point p1, Point p2)
   {
      return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
   }

}