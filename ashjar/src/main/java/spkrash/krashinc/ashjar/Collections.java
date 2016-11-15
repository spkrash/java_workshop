package spkrash.krashinc.ashjar;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Krash on 15.11.2016.
 */
public class Collections {

   public static void main (String[] args){
/*
      String[] langs = new String[4];
      langs[0] = "Java";
      langs[1] = "C#";
      langs[2] = "Python";
      langs[3] = "ObjC;
*/
      String[] langs = {"Java", "C#", "Python", "ObjC"};

/*
      List<String> languages = new ArrayList<String>();
      languages.add("Java");
      languages.add("C#");
      languages.add("Python");
      languages.add("ObjC");
*/
      List<String> languages = Arrays.asList("Java", "C#", "Python", "ObjC");

      System.out.println("Обычный цикл");
      for (int i = 0; i < langs.length; i++  ){
         System.out.println("Я хочу выучить " + langs[i] + ".");
      }

      System.out.println("\n" + "Цикл сразу по массиву + массив из java.utils");
      for (String l : languages){
         System.out.println("Я хочу выучить " + l + ".");
      }

      System.out.println("\n" + "Mассив из java.utils, но цикл обычный");
      for (int i = 0; i < languages.size(); i++){
         System.out.println("Я хочу выучить " + languages.get(i) + ".");
      }

   }
}
