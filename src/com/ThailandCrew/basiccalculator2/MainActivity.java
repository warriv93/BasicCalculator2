package com.ThailandCrew.basiccalculator2;

import java.text.NumberFormat;
import java.awt.*;
import java.util.*;
import java.lang.Object;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
//import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Build;
//import javax.swing;

public class MainActivity extends Activity {
	String spinner_val; 
	String[] method = { "*", "/", "+", "-" };
	double num = 1, multi = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//setting layout
       
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);//fetching view's id
        //Register a callback to be invoked when an item in this AdapterView has been selected
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				
				// TODO Auto-generated method stub
				spinner_val = method[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				spinner_val = "+";
			}
			
		});


		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, method);

		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setSelection(2);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		spinner.setSelection(2);
		
		
		Button calc =  (Button)findViewById(R.id.btnCalculate);
		
		calc.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				EditText number = (EditText)findViewById(R.id.number);
				EditText number2 = (EditText)findViewById(R.id.number2);
				TextView display =  (TextView)findViewById(R.id.display);
				
//				display.setMaxWidth(20);
				
				
				if(number.getText() == null || number2.getText() == null){
//					JOptionPane.showMessageDialog();
				}else{
			
				num = Double.parseDouble(number.getText().toString());
				
				multi = Double.parseDouble(number2.getText().toString());
				
				}
				
				double sum = 0;	
				
				
				
//				if(spinner_val == "*"){
//					sum = num * multi;
//				}
				
				switch(spinner_val){
				
				case "*":   sum = num * multi;
				break;
				case "/":   sum = num / multi;
				break;
				case "+":   sum = num + multi;
				break;
				case "-":   sum = num - multi;
				break;
				
				default: 	sum = num + multi;
				break;
				}
							
				
				
				
				NumberFormat format = NumberFormat.getInstance();
		        format.setMaximumFractionDigits(3);
		        
		        display.setText(format.format(sum)+ " ");
				
//				display.setText(sum + "");
			}
		});
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
