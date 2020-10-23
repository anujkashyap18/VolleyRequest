package com.example.volleyrequest.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volleyrequest.R;
import com.example.volleyrequest.model.HomeWork;
import com.example.volleyrequest.model.Teacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter < StudentAdapter.StudentHolder > {
	
	Context context;
	List < HomeWork > homeWork;
	List < Teacher > teacher_att = new ArrayList <> ( );
	
	public StudentAdapter ( Context context , List < HomeWork > homeWork ) {
		this.context = context;
		this.homeWork = homeWork;
	}
	
	@NonNull
	@Override
	public StudentHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
		
		LayoutInflater inflater = LayoutInflater.from ( context );
		View view = inflater.inflate ( R.layout.custom_homework , parent , false );
		return new StudentHolder ( view );
	}
	
	@Override
	public void onBindViewHolder ( @NonNull StudentHolder holder , int position ) {
		
		holder.id.setText ( homeWork.get ( position ).getId ( ) );
		holder.description.setText ( homeWork.get ( position ).getDescription ( ) );
		holder.subject.setText ( homeWork.get ( position ).getSubject ( ) );
		holder.dueDate.setText ( homeWork.get ( position ).getDue_date ( ) );
		holder.additionalDetail.setText ( homeWork.get ( position ).getAdditional_detail ( ) );
		holder.type.setText ( homeWork.get ( position ).getType ( ) );
		holder.recyclerView.setLayoutManager ( new LinearLayoutManager ( context ) );
		
		JSONArray teachArray = homeWork.get ( position ).getTeacherArray ( );
		for ( int i = 0 ; i < teachArray.length ( ) ; i++ ) {
			try {
				JSONObject obj = teachArray.getJSONObject ( i );
				
				teacher_att.add ( new Teacher ( obj.getString ( "id" ) , obj.getString ( "homework_id" ) , obj.getString ( "file_path" ) ) );
				
			}
			catch ( JSONException e ) {
				e.printStackTrace ( );
			}
		}
		
		holder.recyclerView.setAdapter ( new TeacherAdapter ( context , teacher_att ) );
	}
	
	@Override
	public int getItemCount ( ) {
		return homeWork.size ( );
	}
	
	public class StudentHolder extends RecyclerView.ViewHolder {
		
		TextView id, description, subject, dueDate, additionalDetail, type;
		RecyclerView recyclerView;
		
		public StudentHolder ( @NonNull View itemView ) {
			super ( itemView );
			id = itemView.findViewById ( R.id.tv_id );
			description = itemView.findViewById ( R.id.tv_desc );
			subject = itemView.findViewById ( R.id.tv_subject );
			dueDate = itemView.findViewById ( R.id.tv_due );
			additionalDetail = itemView.findViewById ( R.id.tv_additional );
			type = itemView.findViewById ( R.id.tv_type );
			recyclerView = itemView.findViewById ( R.id.hw_img );
		}
	}
}
