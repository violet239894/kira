package com.example.ch05_buyticket;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void show(View v){
		TextView txv=(TextView)findViewById(R.id.txv);
		txv.setText("");
		String info = "買 ";
		RadioGroup RadioGroup01 =
				(RadioGroup) findViewById(R.id.radioGroup1);
		RadioGroup RadioGroup02 =
				(RadioGroup) findViewById(R.id.radioGroup2);
		RadioGroup RadioGroup03 =
				(RadioGroup) findViewById(R.id.radioGroup3);
		
		// 依選取項目顯示不同訊息
		switch(RadioGroup01.getCheckedRadioButtonId()){
		case R.id.radio0:	// 選今天
			info += "今天";
			break;
		case R.id.radio1:	// 選明天
			info += "明天";
			break;
		default:	// 選後天
			info += "後天";
			break;
		}
		
		// 依選取項目顯示不同訊息
		switch(RadioGroup02.getCheckedRadioButtonId()){
		case R.id.radio20:	// 
			info += " 1張";
			break;
		case R.id.radio21:	// 
			info += " 2張";
			break;
		default:	// 
			info += " 3張";
			break;
		}
		
		// 依選取項目顯示不同訊息
		switch(RadioGroup03.getCheckedRadioButtonId()){
		case R.id.radio30:	// 
			info += " 全票 ";
			break;
		case R.id.radio31:	// 
			info += " 半票 ";
			break;
		default:	// 3
			info += " 敬老票 ";
			break;
		}
		
		txv.setText(info);
	}

}
