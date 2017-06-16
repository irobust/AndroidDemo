package irobust.com.listview.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Roengjit on 6/15/2017 AD.
 */

public interface GithubService {
    @GET("users/irobust/repos")
    Call<List<Repo>> listRepos();
}
