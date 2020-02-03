package com.example.hotel_management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context) {
		super(context, "Hotel", null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		String tablename="create table Hotelmngt(empID int primary key, EmpName Text, DeptName Text,EmplID text unique not null, Email Text unique, Pass Text, EmpAdd Text)";
		arg0.execSQL(tablename);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
