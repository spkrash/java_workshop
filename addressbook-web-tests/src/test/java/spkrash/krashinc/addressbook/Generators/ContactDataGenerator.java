package spkrash.krashinc.addressbook.Generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import spkrash.krashinc.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krash on 25.11.2016.
 */
public class ContactDataGenerator {
   @Parameter(names = "-c", description = "Contact count")
   public int count;

   @Parameter (names = "-f", description = "Target file")
   public String file;

   public static void main(String[] args) throws IOException {
      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander jCommander = new JCommander(generator);
      try {
         jCommander.parse(args);
      } catch (ParameterException ex){
         jCommander.usage();
         return;
      }
      generator.run();
   }

   private void run() throws IOException {
      List<ContactData> contacts = generateContacts(count);
      save(contacts, new File(file));
   }

   private void save(List<ContactData> contacts, File file) throws IOException {
      Writer writer = new FileWriter(file);
      for (ContactData contact : contacts){
         writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getMiddleName()
               , contact.getLastName(), contact.getNickname(), contact.getAddress(), contact.getMobilePhone(), contact.getEmail()
               , contact.getHomePhone(), contact.getWorkPhone(), contact.getEmail2(), contact.getEmail3()));
      }
      writer.close();
   }

   private List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<ContactData>();
      for (int i = 0; i < count; i++) {
         contacts.add(new ContactData().withFirstName(String.format("Bruce %s", i)).withMiddleName(String.format("<B> %s", i))
               .withLastName(String.format("Wayne %s", i)).withNickname(String.format("Batman %s", i))
               .withAddress(String.format("Gotham City %s", i)).withMobileNum(String.format("+38050%s%s%s%s%s%s%s", i, i, i, i, i, i, i))
               .withEmail(String.format("batman%s@gotham.com", i)).withHomePhone(String.format("+380400000000 %s", i))
               .withWorkPhone(String.format("+380600000000 %s", i)).withEmail2(String.format("bruce%s@gotham.com", i))
               .withEmail3(String.format("wayne%s@gotham.com", i)));
      }
      return contacts;
   }

}
