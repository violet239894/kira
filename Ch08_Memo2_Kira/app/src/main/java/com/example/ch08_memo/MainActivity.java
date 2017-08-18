package com.example.ch08_memo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
	implements OnItemClickListener, OnItemLongClickListener{

    String[] aMemo = { // 預設的備忘內容
    		"加法 10+75",
			"減法 60-17",
			"乘法 8*9",
			"除法 245/5" };
    ListView lv; // 顯示備忘錄的 ListView
    ArrayAdapter<String> aa; // ListView 與備忘資料的橋樑
	Toast tos; // 宣告 Toast 物件
	Double da, b, c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView)findViewById(R.id.listView1);
        aa = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1, aMemo);
        
        lv.setAdapter(aa);    //設定 listView1 的內容


        //設定 listView1 被按一下的監聽器
        lv.setOnItemClickListener(this);
        //設定 listView1 被長按的監聽器
        lv.setOnItemLongClickListener(this);

		tos = Toast.makeText(this, "", Toast.LENGTH_SHORT); //建立 Toast 物件
    }

	public void onItemClick(AdapterView<?> a, View v, int pos, long id) {

		String mess = aMemo[pos];
		String st = mess.substring(3);
		if(st.length() > 0) {
			if (st.indexOf("+") > 0) {
				da = Double.parseDouble(st.substring(0, st.indexOf("+")));
				b = Double.parseDouble(st.substring(st.indexOf("+") + 1));
				c = da + b;
				st = String.format("計算: %.2f", c);
			} else if (st.indexOf("-") > 0) {
				da = Double.parseDouble(st.substring(0, st.indexOf("-")));
				b = Double.parseDouble(st.substring(st.indexOf("-") + 1));
				c = da - b;
				st = String.format("計算: %.2f", c);
			} else if (st.indexOf("*") > 0) {
				da = Double.parseDouble(st.substring(0, st.indexOf("*")));
				b = Double.parseDouble(st.substring(st.indexOf("*") + 1));
				c = da * b;
				st = String.format("計算: %.2f", c);
			} else if (st.indexOf("/") > 0) {
				da = Double.parseDouble(st.substring(0, st.indexOf("/")));
				b = Double.parseDouble(st.substring(st.indexOf("/") + 1));
				c = da / b;
				st = String.format("計算: %.2f", c);
			} else {
				st = "無法計算！";
			}

			tos.setText(st);
			tos.show();
		}


	}

	public boolean onItemLongClick(AdapterView<?> a, View v, int pos, long id) {
		//aMemo[pos] = (pos+1) + "."; //將內容清除 (只剩編號)
		//aa.notifyDataSetChanged();  //通知 Adapter 要更新陣列內容

		Intent it = new Intent(this, Edit.class);
		it.putExtra("sum", aMemo[pos]); //附加備忘項目的內容
		startActivityForResult(it, pos); //啟動 Edit 並以項目位置為識別碼
		return true;     			//傳回 true 表示此事件已處理
	}

	protected void onActivityResult(int requestCode, 
			int resultCode, Intent it) {
		if(resultCode == RESULT_OK) {
			aMemo[requestCode] = it.getStringExtra("sum"); // 使用傳回的資料更新陣列內容
			aa.notifyDataSetChanged(); // 通知 Adapter 陣列內容有更新
		}
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
