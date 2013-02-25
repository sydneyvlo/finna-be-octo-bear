package com.sydneylo.flashlight;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	private Button mGetAnswerButton = (Button) findViewById(R.id.button1);
	private Sensor mLight;
	private Camera mCamera;
	private boolean isFlashOn = false;
	private final Parameters p = mCamera.getParameters();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		mGetAnswerButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				buttonClick();
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onRestart();
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void buttonClick() {
		if(isFlashOn) {
			p.setFlashMode(Parameters.FLASH_MODE_OFF);
			mCamera.setParameters(p);
			isFlashOn = false;
		} else {
			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
			mCamera.setParameters(p);
			isFlashOn = true;
		}
	}

}
