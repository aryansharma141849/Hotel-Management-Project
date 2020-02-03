package com.example.hotel_management;

import com.example.hotel_management.R.integer;

import android.R.string;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
Context c;
String [] names ={"The CandleWood Suites Hotel","The Conrad Hotel","The County Hotel","The Given Chy Hotel","The Imperial Hotel","The Indigo Hotel","The M.O Hotel","The Montana Hotel","The Palomar Hotel","The Park Plaza County Hotel","The Royal National Hotel","The Rubens Palace Hotel","The Sejan Inn Hotel"};
String [] prices ={"12500","10200","9500","7500","7000","4000","5000","15000","8550","6500","12000","8500","9000",};
int []images={R.drawable.candlewoodsuites, 
		R.drawable.conrad,
		R.drawable.county,
		R.drawable.givenchy,
		R.drawable.imperial,
		R.drawable.indigo,
		R.drawable.mohotel,
		R.drawable.montana,
		R.drawable.palomar,
		R.drawable.parkplazacounty,
		R.drawable.royalnational,
		R.drawable.rubenspalace,
		R.drawable.sejalinn
};
/*
integer [] btn;*/
public CustomAdapter (Context ctx)
{
	this.c=ctx;
}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return names[pos];
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View view, ViewGroup arg2) {
		
		if(view==null)
		{
		LayoutInflater inflater= (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view=inflater.inflate(R.layout.hotels, null);
			
		}
		//get values
		TextView nametxt= (TextView) view.findViewById(R.id.name);
		TextView pricetxt= (TextView) view.findViewById(R.id.price);
		ImageView img= (ImageView) view.findViewById(R.id.imgId);
		
		/*Button btn= (Button)view.findViewById(R.id.btn);
		*/
		
		//set data
		
		nametxt.setText(names[pos]);
		pricetxt.setText(prices[pos]);
		img.setImageResource(images[pos]);
		/*
		btn.setTag(R.integer.abc_max_action_buttons,pos);*/
		return view;
	}

}
