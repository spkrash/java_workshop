package spkrash.krashinc.ashjar;

/**
 * Created by Krash on 08.11.2016.
 */
public class Primes {
   public static boolean isPrime(int optimus) {
      for (int i = 2; i < optimus; i++) {
         if (optimus % i == 0) {
            return false;
         }
      }
      return true;
   }

   public static boolean isPrimeWhile(int optimus){
      int i = 2;
      while (i < optimus && optimus % i != 0){
         i++;
      }
      return i == optimus;
   }
}
