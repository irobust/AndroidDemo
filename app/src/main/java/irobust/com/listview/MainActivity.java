package irobust.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lstTeams)
    ListView lstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String[] teams = getResources()
                            .getStringArray(R.array.teams);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                                        android.R.layout.simple_list_item_1,
                                        android.R.id.text1, teams);
        lstView.setAdapter(adapter);
    }
}
