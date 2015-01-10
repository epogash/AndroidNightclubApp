package com.ericpogash.efficientclubs;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.maps.GeoPoint;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class GoogleMaps extends FragmentActivity{
	
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.google_maps);
	        
	        
	        GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
	        final GoogleMap map = ((SupportMapFragment) getSupportFragmentManager()
	                .findFragmentById(R.id.map)).getMap();
	        try {
	        List<Address> address;
	        Geocoder coder = new Geocoder(this);
	        String strAddress = getIntent().getStringExtra("CLUB_LOCATION");
	        
	        	
	        address = coder.getFromLocationName(strAddress, 1);
	        Address location = address.get(0);
	        if (address!=null && !address.isEmpty()){
	        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),
	        location.getLongitude()));
	        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
	        map.moveCamera(center);
	        map.animateCamera(zoom);
	        	}
	        } catch (IOException e){
	        	
	        }
	        
	        }
	    }
	

