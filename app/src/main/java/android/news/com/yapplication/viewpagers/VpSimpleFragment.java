package android.news.com.yapplication.viewpagers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yy10017 on 2016/6/15.
 * 自定义的Fragment
 */
public class VpSimpleFragment extends Fragment {


    private String mTitle = "";
    public static final String BUNDLE_TITLE = "bundle_title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null){
            mTitle = bundle.getString(BUNDLE_TITLE);
        }
        TextView textView = new TextView(getActivity());
        textView.setText(mTitle);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    public static VpSimpleFragment getInstance(String title){
        VpSimpleFragment fragment = new VpSimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE,title);
        fragment.setArguments(bundle);
        return fragment;
    }
}
