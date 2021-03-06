package com.dsw.form;

import java.io.File;

import com.dsw.bean.User;

public class ModifyPhotoForm {
	private String username;
	private String password;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String newFile;
	
	public String getNewFile() {
		return newFile;
	}
	public void setNewFile(String newFile) {
		this.newFile = newFile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	public User mappeToUser(){
		User user = new User();
		user.setEmail(username);
		user.setPassword(password);
		user.setPhoto(newFile);
		return user;
	}
}