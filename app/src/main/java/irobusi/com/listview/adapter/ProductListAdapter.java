package irobusi.com.listview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import irobust.com.listview.R;

/**
 * Created by Roengjit on 6/14/2017 AD.
 */

public class ProductListAdapter extends ArrayAdapter {

    private Object[] products;
    private Object[] images;
    int layout;
    public ProductListAdapter(@NonNull Context context,
                              @LayoutRes int resource,
                              @NonNull Object[] objects,
                              @NonNull Object[] images) {
        super(context, resource, objects);
        products = objects;
        this.images = images;
        layout = resource;
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

        String productName = (String) products[position];
        // String imageName = (String) images[position];

        TextView txtName = (TextView) convertView
                            .findViewById(R.id.txtProductView);
        ImageView imgView = (ImageView) convertView
                            .findViewById(R.id.imgProductView);

        txtName.setText(productName);
        //imgView.setImageResource(R.drawable.jacket102);
        Drawable img = getImage((String) images[position]);
        imgView.setImageDrawable(img);

        return convertView;
    }

    private Drawable  getImage(String imageName){
        try {
            InputStream stream = getContext()
                                .getAssets()
                                .open(imageName);
            Drawable d = Drawable.createFromStream(stream, null);
            return d;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
