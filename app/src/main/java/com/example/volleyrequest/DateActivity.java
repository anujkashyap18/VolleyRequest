package com.example.volleyrequest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyrequest.adapter.DateAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DateActivity extends AppCompatActivity {
	
	RecyclerView recyclerView;
	DateAdapter dateAdapter;
	List < HomeWork > dateFilter = new ArrayList <> ( );
	RequestQueue requestQueue;
	
	String url = "https://app.skooledge.com/api/get/homeworklist?school_id=4&batch_id=60";
	String status;
	String id, description, subject, due_date, repeat, priority, additional_detail, type, created, modified;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_date_activity );
		recyclerView = findViewById ( R.id.date_recyclerView );
		recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
		
		requestQueue = Volley.newRequestQueue ( this );
		
		StringRequest stringRequest = new StringRequest ( Request.Method.POST , url , new Response.Listener < String > ( ) {
			@Override
			public void onResponse ( String response ) {
				
				
				try {
					JSONObject object = new JSONObject ( response );
					status = object.getString ( "status" );
					if ( status.equals ( "OK" ) ) {
						
						JSONObject results = object.getJSONObject ( "results" );
						JSONArray list = results.getJSONArray ( "list" );
						
						for ( int i = 0 ; i < list.length ( ) ; i++ ) {
							
							JSONObject jsonObject = list.getJSONObject ( i );
							
							JSONObject schoolHomeWork = jsonObject.getJSONObject ( "SchoolHomework" );
							due_date = schoolHomeWork.getString ( "due_date" );
							dateFilter.add ( new HomeWork ( due_date ) );
							
							
						}
						
						dateAdapter = new DateAdapter ( DateActivity.this , dateFilter );
						recyclerView.setAdapter ( dateAdapter );
						
					}
					
					
				}
				catch ( JSONException e ) {
					e.printStackTrace ( );
				}
				
			}
		} , new Response.ErrorListener ( ) {
			@Override
			public void onErrorResponse ( VolleyError error ) {
			
			}
		} );
		requestQueue.add ( stringRequest );
	}
}