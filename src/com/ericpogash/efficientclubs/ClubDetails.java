package com.ericpogash.efficientclubs;

import android.app.Activity;
import android.app.AlertDialog;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.net.Uri;
import android.net.Uri;
import android.os.Bundle;
//import android.util.Log;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ClubDetails extends Activity {
	protected static final String TAG = null;
	//private static final String appName = "com.google.android.apps.maps";
	//private static final String TAG = "MyActivity";
	protected TextView clubName;
	public TextView clubLocation;
	protected TextView clubTimes;
	protected TextView coverCharge;
	protected TextView clubEvents;
	protected TextView clubInformation;
	protected String appName = "com.google.android.apps.maps";
	protected int clubId;
	
	protected Button googleMaps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.club_details_layout);
		
		//get the clubID int from the Intent in MainActivity
		clubId = getIntent().getIntExtra("CLUB_ID", 0);
		SQLiteDatabase db = (new DbInfo(this)).getWritableDatabase();
		
		//retrieve the clubId value from the Database DbInfo
		Cursor cursor = db.rawQuery("SELECT * FROM clubs WHERE _id = ?", new String [] {"" + clubId});
		
		//if one club is selected
		if (cursor.getCount() == 1) {
			
			cursor.moveToFirst();
			
			//set the text values for each TextView by retrieving the info from the Database
			clubName = (TextView) findViewById(R.id.clubName);
			clubName.setText(cursor.getString(cursor.getColumnIndex("clubName")));
			
			clubLocation = (TextView) findViewById(R.id.clubLocation);
			clubLocation.setText(cursor.getString(cursor.getColumnIndex("clubLocation")));
			
			clubTimes = (TextView) findViewById(R.id.clubTimes);
			clubTimes.setText(cursor.getString(cursor.getColumnIndex("clubTimes")));
			
			coverCharge = (TextView) findViewById(R.id.coverCharge);
			coverCharge.setText(cursor.getString(cursor.getColumnIndex("coverCharge")));
			
			clubEvents = (TextView) findViewById(R.id.clubEvents);
			clubEvents.setText(cursor.getString(cursor.getColumnIndex("clubEvents")));
			
			clubInformation = (TextView) findViewById(R.id.clubInformation);
			clubInformation.setText(cursor.getString(cursor.getColumnIndex("clubInformation")));
			
			googleMaps = (Button) findViewById(R.id.googleMaps);
			googleMaps.setOnClickListener(new OnClickListener(){
				public void onClick(View v) {
					//get the address from the clubLocation TextView 
					
					//Intent mapIntent = new Intent(ClubDetails.this, GoogleMaps.class);
					//mapIntent.putExtra("CLUB_LOCATION", clubLocation.getText().toString());
					//startActivity(mapIntent);
					
					
					//separate method to get addresses by opening Google Maps App
					try {
					String clubAddress = clubLocation.getText().toString();
					clubAddress.replace(' ', '+');
					Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + clubAddress));
					startActivity(mapIntent);
					} catch (Exception e){
						
						Log.e(TAG, "The Google Maps app must be installed on your phone to use this feature.");
						AlertDialog.Builder builder = new AlertDialog.Builder(ClubDetails.this);
						builder.setTitle("Google Maps App Needed");
						builder.setMessage("The Google Maps app must be installed on your phone to use this feature.");
						builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss();
								
							}
						});
						builder.setPositiveButton("Download", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								try {
								    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+appName)));
								} catch (android.content.ActivityNotFoundException anfe) {
								    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id="+appName)));
								}
							}
						});
						builder.show();
					} 
				}	
			});
		}
		
	}
	
}

