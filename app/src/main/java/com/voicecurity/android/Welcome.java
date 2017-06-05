package com.voicecurity.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class Welcome extends AppCompatActivity {

    ImageView slide_image;
    TextView slide_text, slide_next;
    EditText slide_code;
    Button slide_button;

    int btn_mode;
    int next_mode;

    UserSettings userSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        btn_mode = 1;
        next_mode = 1;

        slide_image = (ImageView)findViewById(R.id.slide_image);
        slide_text = (TextView)findViewById(R.id.slide_text);
        slide_next = (TextView)findViewById(R.id.slide_next);
        slide_code = (EditText)findViewById(R.id.slide_code);
        slide_button = (Button)findViewById(R.id.slide_button);

        slide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (btn_mode){
                    case 1:
                        userSettings.codeAgression = slide_code.toString();
                        setContent();
                        btn_mode = 2;
                        break;
                    case 2:
                        userSettings.codeRacket = slide_code.toString();
                        Intent intent = new Intent(Welcome.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }


            }
        });
        slide_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (next_mode){
                    case 1:
                        setContent();
                        next_mode = 2;
                        break;
                    case 2:
                        Intent intent = new Intent(Welcome.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
    private void setContent(){
        slide_image.setImageResource(R.drawable.ic_menu_manage);
        slide_text.setText(R.string.slide_2_welcome);
    }
}
