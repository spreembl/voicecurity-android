package com.voicecurity.android;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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


/**
 * Activity, which will be opened on first app start
 * @author Oleg Kurbatov
 * @author Alexander Krysin
 */
public class WelcomeActivity extends AppCompatActivity {

    Button slide_button;
    private int btnMode = 1;

    ViewPager slider;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //initViews();

        fragmentManager = getSupportFragmentManager();
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putInt("fragment_type", 1);
        args.putInt("fragment_num", 1);
        welcomeFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, welcomeFragment);
        fragmentTransaction.commit();

        slide_button = (Button) findViewById(R.id.slide_button);
        slide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnMode == 1){
                    slider = (ViewPager) findViewById(R.id.viewPager);
                    int fragment_num = slider.getCurrentItem() + 1;
                    WelcomeFragment welcomeFragment = new WelcomeFragment();
                    Bundle args = new Bundle();
                    args.putInt("fragment_type", 2);
                    args.putInt("fragment_num", fragment_num);
                    welcomeFragment.setArguments(args);

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container, welcomeFragment);
                    fragmentTransaction.commit();
                    btnMode = 2;
                } else if (btnMode == 2){
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    /*@SuppressWarnings("ConstantConditions")
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

        pageList.add(createPageView(R.drawable.security_high, R.string.slide_1_welcome));
        pageList.add(createPageView(R.mipmap.ic_launcher, R.string.slide_2_welcome));

        return pageList;
    }

    @NonNull
    private View createPageView(int image_resource, int text) {
        View view = getLayoutInflater().inflate(R.layout.welcome_fragment1_slide, null);
        ImageView slide_image = (ImageView) view.findViewById(R.id.slide_image);
        TextView slide_text = (TextView) view.findViewById(R.id.slide_text);

        slide_image.setImageResource(image_resource);
        slide_text.setText(text);


        return view;
    }*/
}
