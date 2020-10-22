package com.example.volleyrequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
	
	Button show;
	
	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate ( savedInstanceState );
		setContentView ( R.layout.activity_main );
		
		show = findViewById ( R.id.show );
		
		show.setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				startActivity ( new Intent ( MainActivity.this , DateActivity.class ) );
			}
		} );
	}
}