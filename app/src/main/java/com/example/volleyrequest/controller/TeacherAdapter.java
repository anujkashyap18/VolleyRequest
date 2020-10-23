package com.example.volleyrequest.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volleyrequest.R;
import com.example.volleyrequest.model.Teacher;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter < TeacherAdapter.TeacherHolder > {
	
	Context context;
	List < Teacher > teachers;
	
	public TeacherAdapter ( Context context , List < Teacher > teachers ) {
		this.context = context;
		this.teachers = teachers;
	}
	
	@NonNull
	@Override
	public TeacherHolder onCreateViewHolder ( @NonNull ViewGroup parent , int viewType ) {
		
		LayoutInflater inflater = LayoutInflater.from ( context );
		View view = inflater.inflate ( R.layout.custom_teacher_homework , parent , false );
		return new TeacherHolder ( view );
	}
	
	@Override
	public void onBindViewHolder ( @NonNull TeacherHolder holder , int position ) {
		
		Picasso.get ( ).load ( teachers.get ( position ).getFile_path ( ) ).into ( holder.filePath );
		
	}
	
	@Override
	public int getItemCount ( ) {
		return teachers.size ( );
	}
	
	public class TeacherHolder extends RecyclerView.ViewHolder {
		
		ImageView filePath;
		
		public TeacherHolder ( @NonNull View itemView ) {
			super ( itemView );
			filePath = itemView.findViewById ( R.id.filepath );
		}
	}
}
