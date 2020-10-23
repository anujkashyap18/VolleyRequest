package com.example.volleyrequest.model;

public class Teacher {
	
	String id, homework_id, file_path;
	
	public Teacher ( String id , String homework_id , String file_path ) {
		this.id = id;
		this.homework_id = homework_id;
		this.file_path = file_path;
	}
	
	public String getId ( ) {
		return id;
	}
	
	public String getHomework_id ( ) {
		return homework_id;
	}
	
	public String getFile_path ( ) {
		return file_path;
	}
	
	
}
