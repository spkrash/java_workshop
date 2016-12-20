package spkrash.krashinc.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Krash on 20.12.2016.
 */
public class TestBase {

   @BeforeClass
   public void init(){
      RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
   }


   Set<Issue> getIssues() throws IOException {
      String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
      JsonElement parsed = new JsonParser().parse(json);
      JsonElement issues = parsed.getAsJsonObject().get("issues");
      return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
   }

   int createIssue(Issue newIssue) throws IOException {
      String json = RestAssured.given()
            .parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("http://demo.bugify.com/api/issues.json").asString();
      JsonElement parsed = new JsonParser().parse(json);
      return parsed.getAsJsonObject().get("issue_id").getAsInt();
   }

   public boolean isIssueOpen(int issueId) throws IOException {
      String issue = getIssueById(issueId);
      if (issue.equals("Resolved") || issue.equals("Closed")){
         return false;
      }
      return true;
   }

   private String getIssueById(int issueId) {
      String json = RestAssured.get(String.format(
            "http://demo.bugify.com/api/issues/%s.json?attachments=false&comments=false&followers=false&history=false", issueId)).asString();
      JsonElement parsed = new JsonParser().parse(json);
      return parsed.getAsJsonObject().get("issues").getAsJsonArray().getAsJsonArray().get(0)
                   .getAsJsonObject().get("state_name").getAsString();
   }

   public void skipIfNotFixed(int issueId) throws IOException {
      if (isIssueOpen(issueId)) {
         throw new SkipException(String.format("Ignored because of issue: %s", issueId));
      }
   }
}


