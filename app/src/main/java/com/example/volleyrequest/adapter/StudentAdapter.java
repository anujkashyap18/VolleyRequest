package com.example.volleyrequest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volleyrequest.HomeWork;
import com.example.volleyrequest.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter < StudentAdapter.StudentHolder > {
	
	Context context;
	List < HomeWork > homeWork;
	
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
		holder.repeat.setText ( homeWork.get ( position ).getRepeat ( ) );
		holder.priority.setText ( homeWork.get ( position ).getPriority ( ) );
		holder.additionalDetail.setText ( homeWork.get ( position ).getAdditional_detail ( ) );
		holder.type.setText ( homeWork.get ( position ).getType ( ) );
		holder.created.setText ( homeWork.get ( position ).getCreated ( ) );
		holder.created.setText ( homeWork.get ( position ).getCreated ( ) );
		holder.modified.setText ( homeWork.get ( position ).getModified ( ) );
	}
	
	@Override
	public int getItemCount ( ) {
		return homeWork.size ( );
	}
	
	public class StudentHolder extends RecyclerView.ViewHolder {
		
		TextView id, description, subject, dueDate, repeat, priority, additionalDetail, type, created, modified;
		
		public StudentHolder ( @NonNull View itemView ) {
			super ( itemView );
			id = itemView.findViewById ( R.id.tv_id );
			description = itemView.findViewById ( R.id.tv_desc );
			subject = itemView.findViewById ( R.id.tv_subject );
			dueDate = itemView.findViewById ( R.id.tv_due );
			repeat = itemView.findViewById ( R.id.tv_repeat );
			priority = itemView.findViewById ( R.id.tv_priority );
			additionalDetail = itemView.findViewById ( R.id.tv_additional );
			type = itemView.findViewById ( R.id.tv_type );
			created = itemView.findViewById ( R.id.tv_created );
			modified = itemView.findViewById ( R.id.tv_modified );
		}
	}
}
