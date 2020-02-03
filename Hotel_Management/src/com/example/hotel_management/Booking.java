package com.example.hotel_management;

import java.util.Calendar;

import android.R.color;
import android.R.string;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Booking extends Activity {
private static final String TAG = "MainActivity";


	TextView textView, t1,t2;
	EditText editText, e1,e2,e3;
	Button b1;
	TimePickerDialog timePickerDialog;
	Calendar calendar;
	int currenthour;
	int currentminute;
	String AmPm;
	
private DatePickerDialog.OnDateSetListener onDateSetListener;	
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking);
		t1=(TextView)findViewById(R.id.textView2);
		t2=(TextView)findViewById(R.id.textView3);
		textView= (TextView)findViewById(R.id.textView1);
		e1=(EditText)findViewById(R.id.editText1);
		e2= (EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		editText=(EditText)findViewById(R.id.choosetime);
		b1=(Button)findViewById(R.id.button1);
		
		
		//name & Prices
		CustomAdapter adapter=new CustomAdapter(this);
		
		t1.setText(adapter.names[0]);
		t2.setText(adapter.prices[0]);
		
		
		
		//date
		textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Calendar calendar= Calendar.getInstance();
			int year=calendar.get(calendar.YEAR);
			int month=calendar.get(calendar.MONTH);
			int day=calendar.get(calendar.DAY_OF_MONTH);
			
			DatePickerDialog dialog=new DatePickerDialog(Booking.this,
					android.R.style.Animation_Activity,
					onDateSetListener,
					year,month,day);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(color.transparent));
			dialog.show();
			}
		});
		
		onDateSetListener= new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker arg0, int Year, int Month, int Day) {
				// TODO Auto-generated method stub
				Month= Month + 1;
				Log.d(TAG, "onsetdate : MM/DD/YYYY" + Month + "/" + Day + "/" + Year  );
				String date= Month + "/" + Day + "/" + Year ;
				textView.setText(date);
				}
		};
	
		
		//time
		
		editText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			calendar=Calendar.getInstance();
			currenthour=calendar.get(Calendar.HOUR_OF_DAY);
			currentminute=calendar.get(Calendar.MINUTE);
			
			timePickerDialog= new TimePickerDialog(Booking.this, new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker timePicker, int hourofday, int minute) {
					// TODO Auto-generated method stub
					if (hourofday >= 12) {
						AmPm = "PM";
					}
					else{
						AmPm = "Am";
					}
					editText.setText(String.format("%02d:%02d", hourofday,minute) + AmPm);
				}
			}, currenthour, currentminute, false);
			
			timePickerDialog.show();
			}
		});
		
		
		//SMS
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			try{
				String num= e3.getText().toString();
				String Name= e1.getText().toString();
				String date= textView.getText().toString();
				String time= editText.getText().toString();
				String HName= t1.getText().toString();
				String HPrice= t2.getText().toString();
				SmsManager sms= SmsManager.getDefault();
				sms.sendTextMessage(num, null, "Hello" + Name + "thank you for booking" + HName + "at the Price of" + HPrice + "on" + date + "at" + time + "Have a nice Stay!!!" , null, null);
			Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_LONG).show();
			}
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(), "Msg not sent", Toast.LENGTH_LONG).show();
			}
			
				
				
			}
		});



}
}
