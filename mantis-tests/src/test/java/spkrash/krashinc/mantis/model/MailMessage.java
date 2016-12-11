package spkrash.krashinc.mantis.model;

/**
 * Created by Krash on 11.12.2016.
 */
public class MailMessage {

   private final String text;
   private final String to;

   public MailMessage(String to, String text){
      this.to = to;
      this.text = text;
   }
}
