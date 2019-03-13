package irobust.com.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import irobusi.com.listview.adapter.GithubAdapter;
import irobust.com.listview.api.GithubApi;
import irobust.com.listview.api.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import irobust.com.listview.api.Repo;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubReposActivity extends BaseActivity {
    @BindView(R.id.txtResponse) TextView txtResponse;
    @BindView(R.id.lstRepos) ListView lstRepos;
    private List<Repo> listOfRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub_repos);

        Call<List<Repo>> repos = GithubApi.service().listRepos();
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if(response.isSuccessful()){
                    listOfRepos = response.body();
                    GithubAdapter adapter = new GithubAdapter(GitHubReposActivity.this,
                                                        R.layout.list_item_repos,
                                                        response.body());
                    lstRepos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

        lstRepos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GitHubReposActivity.this,
                                            DetailActivity.class);
                intent.putExtra("name",
                                listOfRepos.get(position).getName());
                startActivity(intent);
            }
        });
    }
}
