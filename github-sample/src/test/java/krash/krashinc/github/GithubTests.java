package krash.krashinc.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Krash on 21.12.2016.
 */
public class GithubTests {

   @Test
   public void testCommits() throws IOException {
      Github github = new RtGithub("6fe9928470377ee509dde62c532965fbbafc2bb7");
      RepoCommits commits = github.repos().get(new Coordinates.Simple("spkrash", "java_workshop")).commits();
      for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
         System.out.println(new RepoCommit.Smart(commit).message());
      }
   }
}
