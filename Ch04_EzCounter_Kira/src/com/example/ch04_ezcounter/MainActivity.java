package com.example.ch04_ezcounter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; // �פJ��ť������
import android.view.View.OnLongClickListener; // �פJ��ť������
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity { // ��@ OnLongClickListener ����
	TextView txv;		// �ΨӰѷ� textView1 �����ܼ�
	Button btn, btn2, btn3;			// �ΨӰѷ� button1 �����ܼ�
	int counter = 100;	// �Ψ��x�s�p�ƪ���, ��Ȭ� 0

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txv = (TextView) findViewById(R.id.textView1); // ��X�n�ѷӪ�����
		btn = (Button) findViewById(R.id.button1); // ��X�n�ѷӪ�����
		btn2 = (Button) findViewById(R.id.button2); // ��X�n�ѷӪ�����
		btn3 = (Button) findViewById(R.id.button3); // ��X�n�ѷӪ�����
		
		txv.setText(String.valueOf(counter));
		
		//������ť��
		View.OnClickListener oCListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.button1) { // �P�_�ӷ�����+2
					counter += 2;
					txv.setText(String.valueOf(counter));
				}
				else if(v.getId() == R.id.button2){ // �P�_�ӷ�����-5
					counter -= 5;
					txv.setText(String.valueOf(counter));
				}
				else if(v.getId() == R.id.button3){ // �P�_�ӷ�����*3
					counter *= 3;
					txv.setText(String.valueOf(counter));
				}
				else { // �ӷ����󬰫��s, �N�p�ƭ�100
					counter = 100;
					txv.setText(String.valueOf(counter));
				}				
			}
		};
		
		//������ť��
		View.OnLongClickListener oLCListener = new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				if(v.getId() == R.id.button1) { // �P�_�ӷ�����+2
					txv.setBackgroundColor(Color.BLUE);
				}
				else if(v.getId() == R.id.button2){ // �P�_�ӷ�����-5
					txv.setBackgroundColor(Color.RED);
				}
				else if(v.getId() == R.id.button3){ // �P�_�ӷ�����*3
					txv.setBackgroundColor(Color.YELLOW);
				}
				else { // �ӷ����󬰫��s, �N�p�ƭ�0
					counter = 0;
					txv.setText(String.valueOf(counter));
					txv.setBackgroundColor(Color.WHITE);
				}	
				return true;
			}
		};
		
		
		
		btn.setOnClickListener(oCListener); // �n����ť����, this ��ܬ��ʪ��󥻨�
		btn2.setOnClickListener(oCListener); // �n����ť����, this ��ܬ��ʪ��󥻨�
		btn3.setOnClickListener(oCListener); // �n����ť����, this ��ܬ��ʪ��󥻨�
		txv.setOnClickListener(oCListener); // �n����ť����, this ��ܬ��ʪ��󥻨�
				
		btn.setOnLongClickListener(oLCListener); // �N���ʪ���n�������s��������ť�� 
		btn2.setOnLongClickListener(oLCListener); // �N���ʪ���n�������s��������ť�� 
		btn3.setOnLongClickListener(oLCListener); // �N���ʪ���n�������s��������ť�� 
		txv.setOnLongClickListener(oLCListener); // �N���ʪ���n������r���Ҫ�������ť��
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
