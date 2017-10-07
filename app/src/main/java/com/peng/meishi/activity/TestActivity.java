package com.peng.meishi.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.ImageView;
import com.peng.meishi.R;
import net.qiujuer.genius.blur.StackBlur;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by peng on 16-10-9.
 */
@EActivity(R.layout.activity_test)
public class TestActivity extends Activity {

    @ViewById(R.id.aaaa)
    ImageView image;

    @AfterViews
    public void init(){
        Bitmap b = StackBlur.blurNatively(BitmapFactory.decodeResource(getResources(),R.drawable.menu_bg), 330,
                true);
        image.setImageBitmap(b);
    }


}
