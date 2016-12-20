package spkrash.krashinc.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 20.12.2016.
 */
public class RestAssuredTests  extends TestBase{

   @Test
   public void testCreateIssue() throws IOException {
      skipIfNotFixed(1);
      Set<Issue> oldIssues = getIssues();
      long now = System.currentTimeMillis();
      String summary = String.format("Test issue %s", now);
      Issue newIssue = new Issue().withSubject(summary).withDescription("Krash new test issue desc");
      int issueId = createIssue(newIssue);
      Set<Issue> newIssues = getIssues();
      oldIssues.add(newIssue.withId(issueId));
      assertEquals(newIssues, oldIssues);
   }
}
