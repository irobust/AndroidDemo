package irobusi.com.listview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import irobust.com.listview.R;
import irobust.com.listview.api.Repo;

/**
 * Created by Roengjit on 6/16/2017 AD.
 */

public class GithubAdapter extends ArrayAdapter {
    private int layout;
    private List<Repo> repos;
    public GithubAdapter(@NonNull Context context,
                         @LayoutRes int resource,
                         @NonNull List objects) {
        super(context, resource, objects);
        layout = resource;
        repos = objects;
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(layout, parent, false);
        }
        TextView txtView = (TextView) convertView
                .findViewById(R.id.txtRepoName);
        Repo repo = repos.get(position);
        txtView.setText(repo.getName());

        return convertView;
    }
}
