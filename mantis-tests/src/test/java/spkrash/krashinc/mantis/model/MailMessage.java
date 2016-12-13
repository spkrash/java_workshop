package spkrash.krashinc.mantis.model;

/**
 * Created by Krash on 11.12.2016.
 */
public class MailMessage {

   public String text;
   public String to;

   public MailMessage(String to, String text) {
      this.to = to;
      this.text = text;
   }
}
