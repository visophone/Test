package com.utsoft.cc.test.flycotablayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.utsoft.cc.test.R;

/**
 * Created by 周玉明 on 2017/1/13.
 * Function:Fragment实体类
 * Desc:
 */

public class SimpleFragment extends Fragment {
    private String title;   //标题

    public static SimpleFragment getInstance(String title) {
        SimpleFragment sf = new SimpleFragment();
        sf.title = title;
        return sf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_simplefragment, null);
        TextView card_title_tv = (TextView) v.findViewById(R.id.tv_content_SimpleFragment);
        card_title_tv.setText(title);

        return v;
    }
}
