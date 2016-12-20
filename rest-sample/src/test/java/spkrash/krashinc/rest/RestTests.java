package spkrash.krashinc.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.ir.RuntimeNode;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Krash on 20.12.2016.
 */
public class RestTests extends TestBase{

   @Test
   public void testCreateIssue() throws IOException {
      Set<Issue> oldIssues = getIssues();
      long now = System.currentTimeMillis();
      String summary = String.format("Test issue %s", now);
      Issue newIssue = new Issue().withSubject(summary).withDescription("Krash new test issue desc");
      int issueId = createIssue(newIssue);
      Set<Issue> newIssues = getIssues();
      oldIssues.add(newIssue.withId(issueId));
      assertEquals(newIssues, oldIssues);
   }

   private Set<Issue> getIssues() throws IOException {
      String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json")).returnContent().asString();
      JsonElement parsed = new JsonParser().parse(json);
      JsonElement issues = parsed.getAsJsonObject().get("issues");
      return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
   }

   private Executor getExecutor() {
      return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
   }

   private int createIssue(Issue newIssue) throws IOException {
      String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                      new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
      JsonElement parsed = new JsonParser().parse(json);
      return parsed.getAsJsonObject().get("issue_id").getAsInt();
   }

}
