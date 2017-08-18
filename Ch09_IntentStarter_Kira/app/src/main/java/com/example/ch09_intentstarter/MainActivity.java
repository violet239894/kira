package com.example.ch09_intentstarter;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

	Spinner link; // 顯示選項的 Spinner
	String[] linkList = {"開起網頁", "撥打電話","網路搜尋"};
	EditText inputText;
	int intentName;
		public void onClick(View v) {
    	Intent it = new Intent(Intent.ACTION_VIEW); //建立意圖並指定預設動作
			inputText = (EditText)findViewById(R.id.editText2);
    	switch(intentName) {//讀取按鈕的 Id 來做相關處理
    	case 0 :  //指定網址
    		it.setData(Uri.parse("http://"+inputText.getText().toString()));
    		break;
    	case 1:  //Call
    		it.setData(Uri.parse("tel:"+inputText.getText().toString()));
    		break;
    	case 2:  //搜尋 Web 資料
    		it.setAction(Intent.ACTION_WEB_SEARCH);  //將動作改為搜尋
    		it.putExtra(SearchManager.QUERY, inputText.getText().toString());
    		break;
    	}
    	startActivity(it);  //啟動適合意圖的程式
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		link = (Spinner) findViewById(R.id.spinner); // Spinner
		link.setOnItemSelectedListener(this); // 設定監聽選取事件
		ArrayAdapter<String> linkAd =
				new ArrayAdapter<String>(this,
						android.R.layout.simple_spinner_item,
						linkList);
		linkAd.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		link.setAdapter(linkAd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		intentName = link.getSelectedItemPosition();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
