package spkrash.krashinc.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import spkrash.krashinc.addressbook.model.ContactData;
import spkrash.krashinc.addressbook.model.GroupData;
import spkrash.krashinc.addressbook.model.Groups;

import java.util.List;

/**
 * Created by Krash on 05.12.2016.
 */
public class DbHelper {
   private final SessionFactory sessionFactory;

   public DbHelper(){
      // A SessionFactory is set up once for an application!
      final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
   }

   public Groups groups(){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      List<GroupData> result = session.createQuery( "from GroupData" ).list();
      session.getTransaction().commit();
      session.close();
      return new Groups(result);
   }

}
