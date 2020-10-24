package com.example.volleyrequest.controller;

import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volleyrequest.R;
import com.example.volleyrequest.model.HomeWork;
import com.example.volleyrequest.view.ShowActivity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateAdapter extends RecyclerView.Adapter < DateAdapter.DateHolder > {
	
	Context context;
	List < HomeWork > dateList;
	
	public DateAdapter ( Context context , List < HomeWork > dateList ) {
		this.context = context;
		this.dateList = dateList;
		
	}
	
	@RequiresApi ( api = Build.VERSION_CODES.N )
	private static String getMonth ( String date ) throws ParseException {
		Date d = new SimpleDateFormat ( "yyyy-MM-dd" , Locale.ENGLISH ).parse ( date );
		Calendar cal = Calendar.getInstance ( );
		cal.setTime ( d );
		String monthName = new SimpleDateFormat ( "dd-MMM-yyyy" ).format ( cal.getTime ( ) );
		return monthName;
	}
	
	@NonNull
	@Override
	public DateHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
		LayoutInflater inflater = LayoutInflater.from ( context );
		View view = inflater.inflate ( R.layout.custom_date_filter , parent , false );
		return new DateHolder ( view );
	}
	
	@RequiresApi ( api = Build.VERSION_CODES.O )
	@Override
	public void onBindViewHolder ( @NonNull final DateHolder holder , final int position ) {


//		Calendar calendar = Calendar.getInstance ( );
//		String currentDate = DateFormat.getDateInstance ( DateFormat.FULL ).format ( calendar.getTime ( ) );
		try {
			holder.dateFilter.setText ( getMonth ( dateList.get ( position ).getDue_date ( ) ) );
		}
		catch ( ParseException e ) {
			e.printStackTrace ( );
		}
		
		holder.dateLayout.setOnClickListener ( new View.OnClickListener ( ) {
			@Override
			public void onClick ( View view ) {
				Intent intent = new Intent ( context , ShowActivity.class );
				intent.putExtra ( "due" , dateList.get ( position ).getDue_date ( ) );
				context.startActivity ( intent );
			}
		} );
	}
	
	@Override
	public int getItemCount ( ) {
		return dateList.size ( );
	}
	
	public class DateHolder extends RecyclerView.ViewHolder {
		
		TextView dateFilter;
		LinearLayout dateLayout;
		
		public DateHolder ( @NonNull View itemView ) {
			super ( itemView );
			dateFilter = itemView.findViewById ( R.id.tv_date );
			dateLayout = itemView.findViewById ( R.id.date_linearLayout );
		}
	}
}
