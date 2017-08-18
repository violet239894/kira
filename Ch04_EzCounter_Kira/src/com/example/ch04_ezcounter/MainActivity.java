package com.example.ch04_ezcounter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; // 匯入監聽器介面
import android.view.View.OnLongClickListener; // 匯入監聽器介面
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity { // 實作 OnLongClickListener 介面
	TextView txv;		// 用來參照 textView1 元件的變數
	Button btn, btn2, btn3;			// 用來參照 button1 元件的變數
	int counter = 100;	// 用來儲存計數的值, 初值為 0

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txv = (TextView) findViewById(R.id.textView1); // 找出要參照的物件
		btn = (Button) findViewById(R.id.button1); // 找出要參照的物件
		btn2 = (Button) findViewById(R.id.button2); // 找出要參照的物件
		btn3 = (Button) findViewById(R.id.button3); // 找出要參照的物件
		
		txv.setText(String.valueOf(counter));
		
		//單擊監聽器
		View.OnClickListener oCListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.button1) { // 判斷來源物件+2
					counter += 2;
					txv.setText(String.valueOf(counter));
				}
				else if(v.getId() == R.id.button2){ // 判斷來源物件-5
					counter -= 5;
					txv.setText(String.valueOf(counter));
				}
				else if(v.getId() == R.id.button3){ // 判斷來源物件*3
					counter *= 3;
					txv.setText(String.valueOf(counter));
				}
				else { // 來源物件為按鈕, 將計數值100
					counter = 100;
					txv.setText(String.valueOf(counter));
				}				
			}
		};
		
		//長按監聽器
		View.OnLongClickListener oLCListener = new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.button1) { // 判斷來源物件+2
					txv.setBackgroundColor(Color.BLUE);
				}
				else if(v.getId() == R.id.button2){ // 判斷來源物件-5
					txv.setBackgroundColor(Color.RED);
				}
				else if(v.getId() == R.id.button3){ // 判斷來源物件*3
					txv.setBackgroundColor(Color.YELLOW);
				}
				else { // 來源物件為按鈕, 將計數值0
					counter = 0;
					txv.setText(String.valueOf(counter));
					txv.setBackgroundColor(Color.WHITE);
				}	
				return true;
			}
		};
		
		
		
		btn.setOnClickListener(oCListener); // 登錄監聽物件, this 表示活動物件本身
		btn2.setOnClickListener(oCListener); // 登錄監聽物件, this 表示活動物件本身
		btn3.setOnClickListener(oCListener); // 登錄監聽物件, this 表示活動物件本身
		txv.setOnClickListener(oCListener); // 登錄監聽物件, this 表示活動物件本身
				
		btn.setOnLongClickListener(oLCListener); // 將活動物件登錄為按鈕的長按監聽器 
		btn2.setOnLongClickListener(oLCListener); // 將活動物件登錄為按鈕的長按監聽器 
		btn3.setOnLongClickListener(oLCListener); // 將活動物件登錄為按鈕的長按監聽器 
		txv.setOnLongClickListener(oLCListener); // 將活動物件登錄為文字標籤的長按監聽器
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
