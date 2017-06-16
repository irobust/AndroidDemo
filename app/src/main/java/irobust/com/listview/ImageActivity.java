package irobust.com.listview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {
    @BindView(R.id.imgView) ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

//        Load image from drawable folder
//        imgView.setImageResource(R.drawable.jacket102);

//        int res = getResources()
//                    .getIdentifier("jacket102", "drawable",
//                                    getPackageName());
//        imgView.setImageResource(res);

        // Load image form assets folder
        String imageName = "jacket101.png";
        try {
            InputStream stream = getAssets().open(imageName);
            Drawable d = Drawable.createFromStream(stream, null);
            imgView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
