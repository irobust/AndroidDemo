package irobust.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import irobusi.com.listview.adapter.ProductListAdapter;

public class CustomListviewActivity extends AppCompatActivity {
    @BindView(R.id.lstProducts) ListView lstProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);
        ButterKnife.bind(this);

        String[] products = getResources()
                .getStringArray(R.array.products);
        String[] images = getResources()
                .getStringArray(R.array.images);
        ProductListAdapter adapter = new ProductListAdapter(this,
                R.layout.list_item_product, products, images);
        lstProducts.setAdapter(adapter);
    }
}
