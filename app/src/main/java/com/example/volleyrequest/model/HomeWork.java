package com.example.volleyrequest.model;

import org.json.JSONArray;

public class HomeWork {
	
	String id, description, subject, due_date, repeat, priority, additional_detail, type, created, modified;
	JSONArray teacherArray;
	
	public HomeWork ( String id , String description , String subject , String due_date , String repeat , String priority ,
					  String additional_detail , String type , String created , String modified , JSONArray teacherArray ) {
		this.id = id;
		this.description = description;
		this.subject = subject;
		this.due_date = due_date;
		this.repeat = repeat;
		this.priority = priority;
		this.additional_detail = additional_detail;
		this.type = type;
		this.created = created;
		this.modified = modified;
		this.teacherArray = teacherArray;
	}
	
	public HomeWork ( String due_date ) {
		this.due_date = due_date;
	}
	
	public JSONArray getTeacherArray ( ) {
		return teacherArray;
	}
	
	public String getId ( ) {
		return id;
	}
	
	public String getDescription ( ) {
		return description;
	}
	
	public String getSubject ( ) {
		return subject;
	}
	
	public String getDue_date ( ) {
		return due_date;
	}
	
	public String getRepeat ( ) {
		return repeat;
	}
	
	public String getPriority ( ) {
		return priority;
	}
	
	public String getAdditional_detail ( ) {
		return additional_detail;
	}
	
	public String getType ( ) {
		return type;
	}
	
	public String getCreated ( ) {
		return created;
	}
	
	public String getModified ( ) {
		return modified;
	}
}
