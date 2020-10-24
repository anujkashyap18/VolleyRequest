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
		
		if ( teachers.get ( position ).getFile_type ( ).equals ( "png" ) ) {
			Picasso.get ( ).load ( teachers.get ( position ).getFile_path ( ) ).into ( holder.filePath );
			holder.filePath.setVisibility ( View.VISIBLE );
			holder.document.setVisibility ( View.GONE );
			holder.pdf.setVisibility ( View.GONE );
			holder.xls.setVisibility ( View.GONE );
			holder.ppt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.GONE );
		}
		else if ( teachers.get ( position ).getFile_type ( ).equals ( "doc" ) ) {
			holder.filePath.setVisibility ( View.GONE );
			holder.document.setVisibility ( View.VISIBLE );
			holder.pdf.setVisibility ( View.GONE );
			holder.xls.setVisibility ( View.GONE );
			holder.ppt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.GONE );
		}
		else if ( teachers.get ( position ).getFile_type ( ).equals ( "pdf" ) ) {
			holder.filePath.setVisibility ( View.GONE );
			holder.document.setVisibility ( View.GONE );
			holder.pdf.setVisibility ( View.VISIBLE );
			holder.xls.setVisibility ( View.GONE );
			holder.ppt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.GONE );
		}
		else if ( teachers.get ( position ).getFile_type ( ).equals ( "xls" ) ) {
			holder.filePath.setVisibility ( View.GONE );
			holder.document.setVisibility ( View.GONE );
			holder.pdf.setVisibility ( View.GONE );
			holder.xls.setVisibility ( View.VISIBLE );
			holder.ppt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.GONE );
		}
		else if ( teachers.get ( position ).getFile_type ( ).equals ( "ppt" ) ) {
			holder.filePath.setVisibility ( View.GONE );
			holder.document.setVisibility ( View.GONE );
			holder.pdf.setVisibility ( View.GONE );
			holder.xls.setVisibility ( View.GONE );
			holder.ppt.setVisibility ( View.VISIBLE );
			holder.txt.setVisibility ( View.GONE );
		}
		else {
			holder.filePath.setVisibility ( View.GONE );
			holder.document.setVisibility ( View.GONE );
			holder.pdf.setVisibility ( View.GONE );
			holder.xls.setVisibility ( View.GONE );
			holder.ppt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.GONE );
			holder.txt.setVisibility ( View.VISIBLE );
		}
	}
	
	
	@Override
	public int getItemCount ( ) {
		return teachers.size ( );
	}
	
	public class TeacherHolder extends RecyclerView.ViewHolder {
		
		ImageView filePath, document, pdf, xls, ppt, txt;
		
		
		public TeacherHolder ( @NonNull View itemView ) {
			super ( itemView );
			filePath = itemView.findViewById ( R.id.filepath );
			document = itemView.findViewById ( R.id.doc );
			pdf = itemView.findViewById ( R.id.pdf );
			xls = itemView.findViewById ( R.id.xls );
			ppt = itemView.findViewById ( R.id.ppt );
			txt = itemView.findViewById ( R.id.txt );
			
		}
	}
}
