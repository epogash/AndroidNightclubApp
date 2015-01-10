package com.ericpogash.efficientclubs;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends ListActivity {

	
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected SimpleCursorAdapter adapter;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = (new DbInfo(this)).getWritableDatabase();
		
		cursor = db.rawQuery("SELECT _id, clubName FROM clubs", null);
		
		
		adapter = new SimpleCursorAdapter(
							this, 
							R.layout.view_club,
							cursor,
							//add data from database
							new String[] { "clubName"},
							//TextViews displayed from above String[]
							new int [] { R.id.clubName },
							1);
		
		//add each clubName to each Textview in the ListView
		setListAdapter(adapter);
							 
	}

	//onclick display info
	public void onListItemClick(ListView lv, View view, int position, long id){
		Intent theIntent = new Intent(this, ClubDetails.class);
		cursor = (Cursor) adapter.getItem(position);
		theIntent.putExtra("CLUB_ID", cursor.getInt(cursor.getColumnIndex("_id")));
		startActivity(theIntent);
		
	}
}