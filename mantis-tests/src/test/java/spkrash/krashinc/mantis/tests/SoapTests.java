package spkrash.krashinc.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import spkrash.krashinc.mantis.model.Issue;
import spkrash.krashinc.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 14.12.2016.
 */
public class SoapTests extends TestBase{

   @Test
   public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
      Set<Project> projects = app.soap().getProjects();
      System.out.println(projects.size());
      for (Project project: projects){
         System.out.println(project.getName());
      }
   }

   @Test
   public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
      Set<Project> projects = app.soap().getProjects();
      long now = System.currentTimeMillis();
      String summary = String.format("Test issue %s", now);
      Issue issue = new Issue().withSummary(summary).withDescription("Test issue desc").withProject(projects.iterator().next());
      Issue createdIssue = app.soap().addIssue(issue);
      assertEquals(issue.getSummary(), createdIssue.getSummary());
   }
}
