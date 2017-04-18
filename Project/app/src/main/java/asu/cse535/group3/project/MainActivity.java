package asu.cse535.group3.project;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button navButton = (Button) findViewById(R.id.NavigationButton);



        navButton.setOnClickListener( new android.view.View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, MapPickerActivity.class);
                startActivity(intent);

            }

        });

        Button panicButton = (Button)findViewById(R.id.PanicButton);
        panicButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v){
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // This sample is simply for testing the service, it is not the actual
                        // functionality of the panic button.
                        // Brickyard to Barrett example.
                        DroneServer.RequestDrone(33.4231196, -111.9420774, 33.4148218, -111.929581);
                        System.out.println(DroneServer.GetBestPath());
                    }
                });
                t.run();
            }
        });

        // This code allows us to make service calls from the main thread, or threads spawned there.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
