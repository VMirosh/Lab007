package com.example.nadya_pc.lab007;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener  {

    SensorManager misha;
    Sensor sasha;
    Button reset;
    TextView acc_cor, xyz;
    double x, y, z, X=0, Y=0, Z=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        misha = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sasha=misha.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        reset = (Button) findViewById(R.id.but1);
        reset.setOnClickListener(this);

        acc_cor = (TextView) findViewById(R.id.textout);
        xyz = (TextView) findViewById(R.id.maxtext);
    }

    @Override
    public void onClick (View v){
        xyz.setText("");
        X=0; Y=0; Z=0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0]; y = event.values[1]; z = event.values[2];
        acc_cor.setText("x=" + x + " y=" + y + " z=" + z );
        if (x>X){
            X=x;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if (y > Y){
            Y = y;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if (z > Z){
            Z = z;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (y > Y)){
            X = x;
            Y = y;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (z > Z)){
            X = x;
            Z = z;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((y > Y) && (z > Z)){
            Y = y;
            Z = z;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x > X) && (y > Y) && (z > Z)){
            X = x;
            Y = y;
            Z = z;
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }
        if ((x < X) && (y < Y) && (z < Z)){
            xyz.setText("Xmax=" + X + " Ymax=" + Y + " Zmax=" + Z);
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        misha.registerListener(this, sasha, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
