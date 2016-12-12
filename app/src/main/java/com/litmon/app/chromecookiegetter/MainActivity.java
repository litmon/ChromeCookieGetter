package com.litmon.app.chromecookiegetter;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    static final String IP_ADDRESS = "10.0.1.2:8000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Uri uri = Uri.parse("http://" + IP_ADDRESS + "/index.html");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent intent = new CustomTabsIntent.Builder()
                        .build();

                intent.launchUrl(MainActivity.this, uri);
            }
        });

        if(getIntent().getData() != null){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(getIntent().getDataString());
        }
    }
}
