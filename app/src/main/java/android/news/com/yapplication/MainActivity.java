package android.news.com.yapplication;

import android.app.Activity;
import android.news.com.yapplication.base.BaseActivity;
import android.news.com.yapplication.picasso.ImageLoader;
import android.news.com.yapplication.picasso.PicCallback;
import android.news.com.yapplication.util.LogCat;
import android.news.com.yapplication.util.Uikit;
import android.news.com.yapplication.viewpagers.ViewPagerIndicator;
import android.news.com.yapplication.viewpagers.VpSimpleFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {

//    private static final String PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Request req = new Request.Builder()
//        .url(PIC_URL).
//            get().build();
//
//        OkHttpClient client = new OkHttpClient();
//        client.newCall(req).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                Log.e("dd","ddaaa");
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                byte[] buf = response.body().bytes();
//                File f = new File("/mnt/sdcard/A.png");
//                FileOutputStream fos = new FileOutputStream(f);
//                fos.write(buf);
//                fos.flush();
//
//
//                Log.e("ddddd","dd");
//            }
//        });

//        ImageView view = getView(R.id.iv_show);
//
//        ImageLoader.getInstance().display(PIC_URL, view, new PicCallback() {
//            @Override
//            public void onSuccess() {
//                LogCat.e("MainActivity", "onSuccess()");
//            }
//
//            @Override
//            public void onFail() {
//                LogCat.e("MainActivity", "onFail()");
//            }
//        });
//    }


    private List<String> mTitles = Arrays.asList("page_1","page_2","page_3");
    private List<VpSimpleFragment> mContents = new ArrayList<>();
    private ViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initView();
        initData();
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.scroll(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        mIndicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initData() {
        mContents = new ArrayList<>();
        for (String title : mTitles){
            VpSimpleFragment fragment = VpSimpleFragment.getInstance(title);
            mContents.add(fragment);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };
    }
}
