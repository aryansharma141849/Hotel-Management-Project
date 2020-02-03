package com.example.hotel_management;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hotel_Page extends Activity {
	Button b1,b2;
	int pos=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_hotel__page);
		Intent intent= getIntent();
		pos= intent.getExtras().getInt("Position");
		
		final CustomAdapter adapter=new CustomAdapter(this);
		final ImageView img=(ImageView) findViewById(R.id.imgId);
		final TextView name=(TextView) findViewById(R.id.name);
		final TextView price=(TextView) findViewById(R.id.price);
		
		img.setImageResource(adapter.images[pos]);
		name.setText(adapter.names[pos]);
		price.setText(adapter.prices[pos]);
		//b2=(Button)findViewById(R.id.button2);
		b1=(Button)findViewById(R.id.button1);
		Button btn=(Button)findViewById(R.id.btnnext);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			int position = pos+1;
			
			img.setImageResource(adapter.images[position]);
			name.setText("Name: "+adapter.names[position]);
			price.setText("Price: "+adapter.prices[position]);
			
			if(!(position>=adapter.getCount()-1)){
					
					pos +=1;
				}
				else{
					
					pos= -1;
				}
				
			}
		});
		
	b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		Intent in=new Intent(getApplicationContext(),Booking.class);
		startActivity(in);
				}
	});
	
	
	
	/*b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent in=new Intent(getApplicationContext(),Hotel_View.class);
			startActivity(in);	
		}
	});
	*/
	}








}
