package com.example.ch06_arrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity 
		implements OnItemSelectedListener {

	Spinner year, drink, temp; // 顯示飲品項目與溫度選項的 Spinner
	TextView txv; // 顯示訂單內容的 TextView
	String[] tempSet28 = new String[28]; // 
	String[] tempSet29 = new String[29] ; // 
	String[] tempSet30 = new String[30] ; //
	String[] tempSet31 = new String[31] ; // 
	int i28 = 0, i29 = 0, i30 = 0, i31 = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txv = (TextView) findViewById(R.id.order);
		temp = (Spinner) findViewById(R.id.temp); // Spinner 3
		drink = (Spinner) findViewById(R.id.drink); // Spinner 2
		year = (Spinner) findViewById(R.id.spinner1); // Spinne 1
		year.setOnItemSelectedListener(this); // 設定監聽選取事件
		drink.setOnItemSelectedListener(this); // 設定監聽選取事件
		
		int i28 = 0, i29 = 0, i30 = 0, i31 = 0;
		for(int t28=0; t28<tempSet28.length; t28++){		 
			tempSet28[t28]=String.valueOf(++i28);			
		}
		for(int t29=0; t29<tempSet29.length; t29++){
			tempSet29[t29]=String.valueOf(++i29);			
		}
		for(int t30=0; t30<tempSet30.length; t30++){
			tempSet30[t30]=String.valueOf(++i30);			
		}
		for(int t31=0; t31<tempSet31.length; t31++){
			tempSet31[t31]=String.valueOf(++i31);			
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> sv, View v, 
			int pos, long id) {
		int y = year.getSelectedItemPosition();	// 取被選取的項目
		int d = drink.getSelectedItemPosition();
		String[] tempSet;

		switch(d) { 
            case 0: //1月
            	tempSet = tempSet31;
            	break;
            case 1: //2
            	if (y == 1 && d == 1) // 2016(1),2(1)
        			tempSet = tempSet29;
        		else 
        			tempSet = tempSet28;
                break; 
            case 2: //3
            	tempSet = tempSet31;
                break; 
            case 3: //4
            	tempSet = tempSet30;
                break; 
            case 4: //5
            	tempSet = tempSet31;
                break; 
            case 5: //6
            	tempSet = tempSet30;
                break; 
            case 6: //7
            	tempSet = tempSet31;
                break; 
            case 7: //8
            	tempSet = tempSet31;
                break; 
            case 8: //9
            	tempSet = tempSet30;
                break;
            case 9: //10
            	tempSet = tempSet31;
                break;
            case 10: //11
            	tempSet = tempSet30;
                break;               
            default: //12
            	tempSet = tempSet31; 
        }
				
		ArrayAdapter<String> tempAd = // 依據溫度選項建立 ArrayAdapter
				new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, // 選單位打開時的顯示樣式 
				tempSet); // 溫度選項
		tempAd.setDropDownViewResource( // 設定下拉選單的選項樣式
				android.R.layout.simple_spinner_dropdown_item);
		temp.setAdapter(tempAd); // 設定使用 Adapter 物件
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

	// 按鈕的事件處理方法
	public void showOrder(View v) {
		// 將飲料名稱及溫度選擇組成一個字串

		String msg = year.getSelectedItem() + " 年 " +drink.getSelectedItem() + " 月  " + // 取得飲料名稱
				temp.getSelectedItem() +" 日"; //

		// 將訂單內容顯示在文字方塊中		
		txv.setText(msg);
	}
}