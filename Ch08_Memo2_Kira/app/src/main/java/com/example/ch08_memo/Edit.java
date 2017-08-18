package com.example.ch08_memo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Edit extends Activity {

	TextView txv;
	EditText edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        
        Intent it = getIntent();               //取得傳入的 Intent 物件
        String s = it.getStringExtra("sum");  //讀出名為 "備忘" 的 String 資料

        txv = (TextView)findViewById(R.id.textView1);
        txv.setText(s.substring(0, 3));                 //在畫面左上角顯示編號
        edt = (EditText)findViewById(R.id.editText1);
        if(s.length() > 3)
        	edt.setText(s.substring(3)); //將傳來的備忘資料去除前3個字, 然後填入編輯元件中

    }

    public void onCancel(View v) {  //按取消鈕時
    	setResult(RESULT_CANCELED); // 傳回代表取消的結果碼
    	finish();    //結束活動
    }
    public void onSave(View v) {    //按儲存鈕時
    	Intent it2 = new Intent();
    	it2.putExtra("sum", txv.getText() + " " + edt.getText()); // 附加項目編號與修改後的內容
    	setResult(RESULT_OK, it2); // 傳回代表成功的結果碼, 以及修改的資料
    	finish();    //結束活動
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_edit, menu);
        return true;
    }
}
