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
        
        // 取得3個TextView的物件, 畫面最下方的 LinearLayout
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
        // 取得亂數物件, 產生3個亂數值(rgb值)      
    	// -100 ~ 100
    	// -100 ~ -1 紅色
    	// 0 ~ 59 綠色
        // 60 ~ 100 藍色
    	for(int i = 1; i < 4; i++){
    		Random x = new Random();
    		int number = x.nextInt(201);		// 取-100～100之間的亂數
    		number -= 100;
    		if(i == 1){
    			txvR.setText("Number 1："+ number);	// 顯示亂數值  
    			if(number <= -1){
                	txvR.setTextColor(Color.RED);	// 將文字設為亂數顏(紅)色值
                }else if(number >= 60){
                	txvR.setTextColor(Color.BLUE);	// 將文字設為亂數顏(藍)色值          	
                }else{
                	txvR.setTextColor(Color.GREEN);	// 將文字設為亂數顏(綠)色值
                }    			
    		}
    		if(i == 2){
    			txvG.setText("Number 2："+ number);	// 顯示亂數值   
    			if(number <= -1){
                	txvG.setTextColor(Color.RED);	// 將文字設為亂數顏(紅)色值
                }else if(number >= 60){
                	txvG.setTextColor(Color.BLUE);	// 將文字設為亂數顏(藍)色值          	
                }else{
                	txvG.setTextColor(Color.GREEN);	// 將文字設為亂數顏(綠)色值
                } 
    		}
    		if(i == 3){
    			txvB.setText("Number 3："+ number);	// 顯示亂數值   
    			if(number <= -1){
                	txvB.setTextColor(Color.RED);	// 將文字設為亂數顏(紅)色值
                }else if(number >= 60){
                	txvB.setTextColor(Color.BLUE);	// 將文字設為亂數顏(藍)色值          	
                }else{
                	txvB.setTextColor(Color.GREEN);	// 將文字設為亂數顏(綠)色值
                } 
    		}
    		
    		//		  		
    	}   	  	
    	randomMoney();
    }

	private void randomMoney() {
		//大樂透1 ~ 49	
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
