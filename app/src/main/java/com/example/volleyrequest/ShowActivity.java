package com.example.volleyrequest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {
	
	RecyclerView recyclerView;
	StudentAdapter studentAdapter;
	List < HomeWork > data = new ArrayList <> ( );
	
	String url = "https://app.skooledge.com/api/get/homeworklist?school_id=4&batch_id=60";
	
	RequestQueue requestQueue;
	String id, description, subject, due_date, repeat, priority, additional_detail, type, created, modified;
	String status, result, list;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_show );
		recyclerView = findViewById ( R.id.recyclerView );
		recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
		requestQueue = Volley.newRequestQueue ( this );
		
		
		StringRequest stringRequest = new StringRequest ( Request.Method.POST , url , new Response.Listener < String > ( ) {
			@Override
			public void onResponse ( String response ) {
				
				Log.d ( getClass ( ).getSimpleName ( ) , "response" + response );
				Toast.makeText ( ShowActivity.this , "response : " + response , Toast.LENGTH_SHORT ).show ( );
				
				try {
					JSONObject object = new JSONObject ( response );
					status = object.getString ( "status" );
					if ( status.equals ( "OK" ) ) {
						
						JSONObject results = object.getJSONObject ( "results" );
						JSONArray list = results.getJSONArray ( "list" );
						
						for ( int i = 0 ; i < list.length ( ) ; i++ ) {
							
							JSONObject jsonObject = list.getJSONObject ( i );
							
							JSONObject schoolHomeWork = jsonObject.getJSONObject ( "SchoolHomework" );
							
							id = schoolHomeWork.getString ( "id" );
							
							description = schoolHomeWork.getString ( "description" );
							subject = schoolHomeWork.getString ( "subject" );
							due_date = schoolHomeWork.getString ( "due_date" );
							repeat = schoolHomeWork.getString ( "repeat" );
							priority = schoolHomeWork.getString ( "priority" );
							additional_detail = schoolHomeWork.getString ( "additional_detail" );
							type = schoolHomeWork.getString ( "type" );
							created = schoolHomeWork.getString ( "created" );
							modified = schoolHomeWork.getString ( "modified" );
							
							data.add ( new HomeWork ( id , description , subject , due_date , repeat , priority , additional_detail , type , created , modified ) );
						}
						studentAdapter = new StudentAdapter ( ShowActivity.this , data );
//						Toast.makeText ( ShowActivity.this , "adapter"+studentAdapter 	 , Toast.LENGTH_SHORT ).show ( );
						recyclerView.setAdapter ( studentAdapter );
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