package com.example.ch02_edittext;

import com.example.ch02_edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
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

	public void sayHello(View v){
		// ���o�N��G���� EditText �� TextView ������
		EditText name = (EditText)findViewById(R.id.editText1);
		EditText pass = (EditText)findViewById(R.id.editText2);
		EditText email = (EditText)findViewById(R.id.editText3);
		TextView txv = (TextView)findViewById(R.id.txv);

		txv.setTextSize(20);
		txv.setText("�b��:"+name.getText().toString() + "\n" +
				    "�K�X:"+pass.getText().toString()  + "\n" +
				    "E-Mail:"+email.getText().toString());
	}
	public void clear(View v){
		// ���o�N��G���� EditText �� TextView ������
		EditText name = (EditText)findViewById(R.id.editText1);
		EditText pass = (EditText)findViewById(R.id.editText2);
		EditText email = (EditText)findViewById(R.id.editText3);
		TextView txv = (TextView)findViewById(R.id.txv);
		name.setText("");
		pass.setText("");
		email.setText("");
		txv.setText("");
	}
}
