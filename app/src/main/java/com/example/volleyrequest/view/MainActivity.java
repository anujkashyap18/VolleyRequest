package com.example.volleyrequest.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.volleyrequest.R;

public class MainActivity extends AppCompatActivity {
	
	ImageView show;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_main );
		
		show = findViewById ( R.id.show );
		
		show.animate ( ).alpha ( 1f ).setDuration ( 3000 );
		new Handler ( ).postDelayed ( new Runnable ( ) {
			@Override
			public void run ( ) {
				
				startActivity ( new Intent ( MainActivity.this , DateActivity.class ) );
				finish ( );
			}
		} , 5000 );
		
	}
}