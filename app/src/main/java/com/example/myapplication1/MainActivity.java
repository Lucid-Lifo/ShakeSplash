package com.example.myapplication1;

import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor accelerometer;
    ConstraintLayout rootlayout;

    private float lastx, lasty, lastz;
    private int threshold;
    private Random randomColorGenerator;
    private long lasttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rootlayout = findViewById(R.id.main);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sm != null) {
            accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

        threshold = 800; // Set sensitivity
        randomColorGenerator = new Random();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        long currenttime = System.currentTimeMillis();
        if ((currenttime - lasttime) > 100) {
            long difftime = currenttime - lasttime;
            lasttime = currenttime;

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float speed = Math.abs(x + y + z - lastx - lasty - lastz) / difftime * 10000;

            if (speed > threshold) {
                changeBackgroundColor();
            }

            lastx = x;
            lasty = y;
            lastz = z;
        }
    }

    void changeBackgroundColor() {
        int color = Color.rgb(
                randomColorGenerator.nextInt(256),
                randomColorGenerator.nextInt(256),
                randomColorGenerator.nextInt(256)
        );
        rootlayout.setBackgroundColor(color);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used
    }
}