package com.example.ch06_ticketspinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener {
	TextView textView4;	
	Spinner cinema;	
	EditText editText1, editText2, editText3;
	String[] area = {"半徑*半徑*3.14","半徑*2*3.14"};
	String[] perimeter = {"邊長*邊長","邊長*4"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		editText3 = (EditText)findViewById(R.id.editText3);
		textView4 = (TextView)findViewById(R.id.textView4);
		cinema = (Spinner) findViewById(R.id.spinner1);
		cinema.setOnItemSelectedListener(this);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void order(View v){
		if ("".equals(editText3.getText().toString())){
			textView4.setText("請輸入數值！");	
		}else{
			Double w = Double.parseDouble(editText3.getText().toString());
			int c = cinema.getSelectedItemPosition();	// 取被選取的項目
			Double a = null, b = null ;
			if(c == 0){
				a = w*w*3.14;
				b = w*2*3.14;
			}else{
				a = w*w;
				b = w*4;
			}
			textView4.setText(String.format("面積: %.2f 周長: %.2f", a, b));	
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		int c = cinema.getSelectedItemPosition();
		if(c == 0){
			editText1.setText(area[0]);
			editText2.setText(area[1]);
		}else{
			editText1.setText(perimeter[0]);
			editText2.setText(perimeter[1]);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
