package com.example.ch02_button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}

	int size = 20; // 字型大小, 初始值 30(SP)
	public void bigButton(View v){
		TextView txv = (TextView)findViewById(R.id.txv);
		txv.setTextSize(++size);
	}
	public void smallButton(View v){
		TextView txv = (TextView)findViewById(R.id.txv);
		txv.setTextSize(--size);
	}
	public void resetButton(View v){
		TextView txv = (TextView)findViewById(R.id.txv);
		size = 20;
		txv.setTextSize(size);
	}
}
