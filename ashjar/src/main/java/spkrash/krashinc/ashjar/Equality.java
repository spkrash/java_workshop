package spkrash.krashinc.ashjar;

/**
 * Created by Krash on 31.10.2016.
 */
public class Equality {
   public static void main(String[] args){
      String s1 = "Firefox 2.0";
      String s2 = "Firefox " + Math.sqrt(4.0);

      System.out.println(s1 == s2);
      System.out.println(s1.equals(s2));
   }
}
