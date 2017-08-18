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
		String info = "�R ";
		RadioGroup RadioGroup01 =
				(RadioGroup) findViewById(R.id.radioGroup1);
		RadioGroup RadioGroup02 =
				(RadioGroup) findViewById(R.id.radioGroup2);
		RadioGroup RadioGroup03 =
				(RadioGroup) findViewById(R.id.radioGroup3);
		
		// �̿��������ܤ��P�T��
		switch(RadioGroup01.getCheckedRadioButtonId()){
		case R.id.radio0:	// �蘆��
			info += "����";
			break;
		case R.id.radio1:	// �����
			info += "����";
			break;
		default:	// ����
			info += "���";
			break;
		}
		
		// �̿��������ܤ��P�T��
		switch(RadioGroup02.getCheckedRadioButtonId()){
		case R.id.radio20:	// 
			info += " 1�i";
			break;
		case R.id.radio21:	// 
			info += " 2�i";
			break;
		default:	// 
			info += " 3�i";
			break;
		}
		
		// �̿��������ܤ��P�T��
		switch(RadioGroup03.getCheckedRadioButtonId()){
		case R.id.radio30:	// 
			info += " ���� ";
			break;
		case R.id.radio31:	// 
			info += " �b�� ";
			break;
		default:	// 3
			info += " �q�Ѳ� ";
			break;
		}
		
		txv.setText(info);
	}

}
