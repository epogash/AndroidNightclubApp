package com.ericpogash.efficientclubs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbInfo extends SQLiteOpenHelper{

	public static final String NAME_OF_DATABASE = "clublist";
	
	
	public DbInfo(Context context) {
		super(context, NAME_OF_DATABASE, null, 1);
		
	}


	@Override
	public void onCreate(SQLiteDatabase db) {

		String tablecreation = "CREATE TABLE IF NOT EXISTS clubs (" +
								"_id INTEGER PRIMARY KEY AUTOINCREMENT, clubName TEXT, clubLocation TEXT, " + 
								"clubTimes TEXT, coverCharge TEXT, clubEvents TEXT, clubInformation TEXT)";
		db.execSQL(tablecreation);
		
		ContentValues values = new ContentValues();
		
		values.put("clubName", ":08 Seconds");
		values.put("clubLocation", " 201 W University Ave, Gainesville, FL 32601");
		values.put("clubTimes", "Hours: Open on Thursdays, Fridays, and Saturdays: 10PM-2AM");
		values.put("coverCharge", "Cover Charge: Thursdays-$7 if you are under 21 and $5 if you are over 21, " +
				"Fridays- $7 if you are under 21 and $10 if you are over 21, " +
				"Saturdays- $7 if you are under 21 and $5 if you are over 21");
		values.put("clubEvents", "Age: 18+");
		values.put("clubInformation", 
				"\nEight Seconds is Gainesville's #1 country music nightclub and venue" +
				"\n\nThursdays: Ladies drink free Wells until 12:30" +
				"\n\nFridays: $10 aycd (Wells and domestic bottles)" +
				"\n\nSaturdays: $2 Smirnoff, Captain, and Jim Beam with the option for a $25 aycd band that includes top shelf liquor" +
				"\n\nThursdays, Fridays, and Saturdays: Free line dancing and swing dancing lessons every night at 10:45.  "
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "Envy");
		values.put("clubLocation", "1728 W University Ave, Gainesville, FL -----");
		values.put("clubTimes", "Hours: Open on Wednesdays, Fridays, and Saturdays: 10PM-2AM");
		values.put("coverCharge", "Cover Charge: FREE for everyone on Saturdays, $5 if over 21 and $7 if underage on Wednesdays and Fridays");
		values.put("clubEvents", "Age: 18+");
		values.put("clubInformation", 
				"\n Seconds"
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "Fubar");
		values.put("clubLocation", "225 W University Ave, Gainesville, FL -----");
		values.put("clubTimes", ":08 Seconds");
		values.put("coverCharge", "Cover Charge: ");
		values.put("clubEvents", "Age: ");
		values.put("clubInformation", 
				"\nMug Night Mondays - Get a mug, enter the" +
				" beer pong tourney and get free drinks and drafts all night long. Bring " +
				"the mug back on future Mondays for a reduced cover. " +
				"\n\nKoozie Tuesdays - $2 Wells and Bottled Beer." +
				"\n\nWednesdays - available for rental (gainesvillefubar@hotmail.com)" +
				"\n\nDirty Talk Thursdays, Ladies Night - Ladies drink free ALL night, $1 bottled " +
				"beers for the guys. DJ LuNy" +
				"\n\nTGIFubar Fridays - Pay one cover and then no other... FREE drinks FREE drafts " +
				"ALL night. DJ Docta Dawe from Orlando" +
				"\n\n3, 2, 1, GO! Saturdays - Free Bud Light ALL NIGHT, $3 Calls, $2 Bottled Beer, " +
				"$1 Jello Shots, DJ Matt Mobs and DJ Estefunk" +
				"\n\nSundays are available for rentals (gainesvillefubar@hotmail.com)"
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "Grog House");
		values.put("clubLocation", "1718 W University Ave, Gainesville, FL -----");
		values.put("clubTimes", "Hours: Open on Tuesdays 10PM-2AM, Wednesdays 9:30PM-2AM, " +
				"Fridays and Saturdays 8PM-2AM");
		values.put("coverCharge", "Cover Charge: ");
		values.put("clubEvents", "Age: ");
		values.put("clubInformation", 
				"\nTuesdays: All You Can Drink- All you can drink wells and drafts," +
				"with a live video DJ" +
				"\n\nWednesdays: Ladies Night- Ladies drink free until 1AM, FREE beer for everyone from 9:30PM-10:30PM," +
				"and $3 Captain all night" +
				"\n\nFridays: Beat the Clock- Pitchers start at 25 cents at 9PM and go up 25 cents every 15 minutes, " +
				"$2 wells all night" +
				"\n\nSaturdays: Drink Free- Free wells and drafts 9PM-12:30AM"
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "Sharab Lounge");
		values.put("clubLocation", ":08 Seconds");
		values.put("clubTimes", "Hours: Thursdays 10PM-2AM, Fridays and Saturdays 9PM-2AM");
		values.put("coverCharge", "Cover Charge: ");
		values.put("clubEvents", "Age: 18+ on Thursdays, 21+ on Fridays and Saturdays");
		values.put("clubInformation", 
				"\nThursdays: Open Format w/ DJ Shea Michaels and $4 Wells All Night" +
				"\n\nFridays: House/Open Format w/ DJ JD and Downstairs Lounge w/ DJ Vi" +
				"\n\nSaturdays: Hip Hop/Open Format w/ DJ Ruckus and Downstairs Drum&Bass w/ DJ Flaco" +
				"\n\nNote: Dress code is strictly enforced. No Shorts, Sandals, Torn Jeans, Ball Caps, or Sunglasses."
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "Status");
		values.put("clubLocation", "17 SE 1st St., Gainesville, FL -----");
		values.put("clubTimes", ":08 Seconds");
		values.put("coverCharge", "Cover Charge: ");
		values.put("clubEvents", ":08 Seconds");
		values.put("clubInformation", 
				"\n:08 Seconds"
				);
		db.insert("clubs", null, values);
		
		values.put("clubName", "The Vault");
		values.put("clubLocation", "238 W University Ave, Gainesville, FL 32601");
		values.put("clubTimes", "Hours: Open on Fridays and Saturdays 9PM-3AM");
		values.put("coverCharge", "Cover Charge: ");
		values.put("clubEvents", ":08 Seconds");
		values.put("clubInformation", 
				"\n:08 Seconds"
				);
		db.insert("clubs", null, values);
		
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS clubs");
		onCreate(db);
	}
	
	
}
