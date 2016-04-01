package tech.sree.com.myservicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View V){
        Intent intent = new Intent(this,MyserviceIntent.class);
        startService(intent);

    }
    public void stopService(View V){
        Intent intent = new Intent(this,MyserviceIntent.class);
        stopService(intent);
    }
}
