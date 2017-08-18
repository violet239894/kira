package com.example.ch03_randomcolor;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.example.ch03_randomcolor.*;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txvR,txvG,txvB,money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ���o3��TextView������, �e���̤U�誺 LinearLayout
        txvR = (TextView) findViewById(R.id.txvR);
        txvG= (TextView) findViewById(R.id.txvG);
        txvB= (TextView) findViewById(R.id.txvB);
        money = (TextView)findViewById(R.id.textView1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void changeColor(View v){                              
        // ���o�üƪ���, ����3�Ӷüƭ�(rgb��)      
    	// -100 ~ 100
    	// -100 ~ -1 ����
    	// 0 ~ 59 ���
        // 60 ~ 100 �Ŧ�
    	for(int i = 1; i < 4; i++){
    		Random x = new Random();
    		int number = x.nextInt(201);		// ��-100��100�������ü�
    		number -= 100;
    		if(i == 1){
    			txvR.setText("Number 1�G"+ number);	// ��ܶüƭ�  
    			if(number <= -1){
                	txvR.setTextColor(Color.RED);	// �N��r�]���ü��C(��)���
                }else if(number >= 60){
                	txvR.setTextColor(Color.BLUE);	// �N��r�]���ü��C(��)���          	
                }else{
                	txvR.setTextColor(Color.GREEN);	// �N��r�]���ü��C(��)���
                }    			
    		}
    		if(i == 2){
    			txvG.setText("Number 2�G"+ number);	// ��ܶüƭ�   
    			if(number <= -1){
                	txvG.setTextColor(Color.RED);	// �N��r�]���ü��C(��)���
                }else if(number >= 60){
                	txvG.setTextColor(Color.BLUE);	// �N��r�]���ü��C(��)���          	
                }else{
                	txvG.setTextColor(Color.GREEN);	// �N��r�]���ü��C(��)���
                } 
    		}
    		if(i == 3){
    			txvB.setText("Number 3�G"+ number);	// ��ܶüƭ�   
    			if(number <= -1){
                	txvB.setTextColor(Color.RED);	// �N��r�]���ü��C(��)���
                }else if(number >= 60){
                	txvB.setTextColor(Color.BLUE);	// �N��r�]���ü��C(��)���          	
                }else{
                	txvB.setTextColor(Color.GREEN);	// �N��r�]���ü��C(��)���
                } 
    		}
    		
    		//		  		
    	}   	  	
    	randomMoney();
    }

	private void randomMoney() {
		//�j�ֳz1 ~ 49	
		Set<Integer> intRan = new HashSet<Integer>();
		for(int r = 0; intRan.size() <= 6; r++){
			Random rm = new Random();
    		int xm = rm.nextInt(49)+1;		
    		intRan.add(xm);
		}
		
		String aaa = "";
		for(int rn : intRan){
			aaa += "[ " + Integer.toString(rn) + " ]";
		}
		    		
		money.setTextSize(22);
		money.setText(aaa);
		
	} 
}
