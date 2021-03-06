package com.example.volleyrequest.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyrequest.R;
import com.example.volleyrequest.controller.StudentAdapter;
import com.example.volleyrequest.model.HomeWork;
import com.example.volleyrequest.model.Teacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {
	
	RecyclerView recyclerView;
	StudentAdapter studentAdapter;
	List < HomeWork > data = new ArrayList <> ( );
	List < Teacher > teacherList = new ArrayList <> ( );
	
	String url = "https://app.skooledge.com/api/get/homeworklist?school_id=4&batch_id=60";
	RequestQueue requestQueue;
	String id, description, subject, due_date, repeat, priority, additional_detail, type, created, modified;
	String status, dueDate;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_show );
		
		recyclerView = findViewById ( R.id.recyclerView );
		
		recyclerView.setLayoutManager ( new LinearLayoutManager ( this , RecyclerView.HORIZONTAL , false ) );
		SnapHelper helper = new PagerSnapHelper ( );
		requestQueue = Volley.newRequestQueue ( this );
		helper.attachToRecyclerView ( recyclerView );
		dueDate = getIntent ( ).getStringExtra ( "due" );
		
		StringRequest stringRequest = new StringRequest ( Request.Method.POST , url , new Response.Listener < String > ( ) {
			@Override
			public void onResponse ( String response ) {
				try {
					Log.d ( getClass ( ).getSimpleName ( ) , "VOLLEY RESPONSE : " + response );
					JSONObject object = new JSONObject ( response );
					status = object.getString ( "status" );
					if ( status.equals ( "OK" ) ) {
						
						JSONObject results = object.getJSONObject ( "results" );
						JSONArray list = results.getJSONArray ( "list" );
						for ( int i = 0 ; i < list.length ( ) ; i++ ) {
							
							JSONObject obj = list.getJSONObject ( i );
							JSONObject schoolHomeWork = obj.getJSONObject ( "SchoolHomework" );
							JSONArray teacherObject = obj.getJSONArray ( "Teacher_Attachment" );
							
							
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
							if ( due_date.equals ( dueDate ) ) {
								data.add ( new HomeWork ( id , description , subject , due_date , repeat ,
										priority , additional_detail , type , created , modified , teacherObject ) );
							}
						}
						studentAdapter = new StudentAdapter ( ShowActivity.this , data );
						recyclerView.setAdapter ( studentAdapter );
						
					}
				}
				catch ( JSONException e ) {
					Log.d ( getClass ( ).getSimpleName ( ) , "VOLLEY JSON ERROR : " + e.getLocalizedMessage ( ) );
				}
			}
		} , new Response.ErrorListener ( ) {
			@Override
			public void onErrorResponse ( VolleyError error ) {
				Log.d ( getClass ( ).getSimpleName ( ) , "VOLLEY ERROR : " + error.getLocalizedMessage ( ) );
				Toast.makeText ( ShowActivity.this , "VOLLEY ERROR : " + error.getLocalizedMessage ( ) , Toast.LENGTH_SHORT ).show ( );
			}
		} );
		requestQueue.add ( stringRequest );
	}
}