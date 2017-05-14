package com.voicecurity.android;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rd.Orientation;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    Button slide_button;
    ImageView slide_image;
    TextView slide_text;
    TextView slide_textdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();

        slide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @SuppressWarnings("ConstantConditions")
    private void initViews() {
        WelcomeAdapter adapter = new WelcomeAdapter();
        adapter.setData(createPageList());

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        PageIndicatorView indicatorView = (PageIndicatorView) findViewById(R.id.pageindicatorview);
        indicatorView.setViewPager(pager);
        indicatorView.setOrientation(Orientation.HORIZONTAL);
    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        pageList.add(createPageView(R.drawable.security_high, R.string.slide_1_welcome, R.string.slide_1_wd, false));
        pageList.add(createPageView(R.mipmap.ic_launcher, R.string.slide_2_welcome, R.string.slide_2_wd, false));
        pageList.add(createPageView(R.mipmap.ic_launcher, R.string.slide_3_welcome,R.string.slide_3_wd, false));
        pageList.add(createPageView(R.mipmap.ic_launcher, R.string.slide_4_welcome, R.string.slide_4_wd, true));

        return pageList;
    }

    @NonNull
    private View createPageView(int image_resource, int text, int description, boolean button_active) {
        View view = getLayoutInflater().inflate(R.layout.welcome_slide, null);
        slide_image = (ImageView) view.findViewById(R.id.slide_image);
        slide_text = (TextView) view.findViewById(R.id.slide_text);
        slide_textdescription = (TextView) view.findViewById(R.id.slide_textdescription);
        slide_button = (Button) view.findViewById(R.id.slide_button);
        slide_image.setImageResource(image_resource);
        slide_text.setText(text);
        slide_textdescription.setText(description);
        if(button_active) slide_button.setBackground(getResources().getDrawable(R.drawable.style_nightblue_button));
        return view;
    }
}
