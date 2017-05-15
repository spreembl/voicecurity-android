package com.voicecurity.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rd.Orientation;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Бог on 15/05/17.
 */

public class WelcomeFragment extends Fragment {
    private int fragment_type;
    private int fragment_num;

    public void setArguments(Bundle args) {
        this.fragment_type = args.getInt("fragment_type", 1);
        this.fragment_num = args.getInt("fragment_num", 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(fragment_type == 1 ? R.layout.welcome_fragment1 : R.layout.welcome_fragment2, container, false);
        setContent(rootView, fragment_type, fragment_num);
        return rootView;
    }

    private void setContent(View rootView, int fragment_type, int fragment_num) {
        switch(fragment_type) {
            case 1:
                initViews(rootView);
                break;
            case 2:
                ImageView img1 = (ImageView) rootView.findViewById(R.id.slide_conimage1);
                TextView txt1 = (TextView) rootView.findViewById(R.id.slide_context1);
                ImageView img2 = (ImageView) rootView.findViewById(R.id.slide_conimage2);
                TextView txt2 = (TextView) rootView.findViewById(R.id.slide_context2);
                ImageView img3 = (ImageView) rootView.findViewById(R.id.slide_conimage3);
                TextView txt3 = (TextView) rootView.findViewById(R.id.slide_context3);

                img1.setImageResource(fragment_num == 1 ? R.mipmap.ic_launcher : R.mipmap.ic_launcher);
                img2.setImageResource(fragment_num == 1 ? R.mipmap.ic_launcher : R.mipmap.ic_launcher);
                img3.setImageResource(fragment_num == 1 ? R.mipmap.ic_launcher : R.mipmap.ic_launcher);
                txt1.setText(fragment_num == 1 ? R.string.slide_2_welcome : R.string.slide_1_welcome);
                txt2.setText(fragment_num == 1 ? R.string.slide_welcome : R.string.slide_1_welcome);
                txt3.setText(fragment_num == 1 ? R.string.slide_1_welcome : R.string.slide_2_welcome);
                break;
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void initViews(View rootView) {
        WelcomeAdapter adapter = new WelcomeAdapter();
        adapter.setData(createPageList());

        ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        PageIndicatorView indicatorView = (PageIndicatorView) rootView.findViewById(R.id.pageindicatorview);
        indicatorView.setViewPager(pager);
        indicatorView.setOrientation(Orientation.HORIZONTAL);
    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();

        pageList.add(createPageView(R.drawable.security_high, R.string.slide_1_welcome));
        pageList.add(createPageView(R.mipmap.ic_launcher, R.string.slide_2_welcome));

        return pageList;
    }

    @NonNull
    private View createPageView(int image_resource, int text) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.welcome_fragment1_slide, null);
        ImageView slide_image = (ImageView) view.findViewById(R.id.slide_image);
        TextView slide_text = (TextView) view.findViewById(R.id.slide_text);

        slide_image.setImageResource(image_resource);
        slide_text.setText(text);


        return view;
    }
}
