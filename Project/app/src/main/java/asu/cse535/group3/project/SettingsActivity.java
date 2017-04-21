package asu.cse535.group3.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Button fButton = (Button) findViewById(R.id.settingsFeedback);
        fButton.setOnClickListener( new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(SettingsActivity.this, MessageCenter.class);
                startActivity(intent);
            }

        });

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener( new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v){
                finish();
            }});
    }
}
