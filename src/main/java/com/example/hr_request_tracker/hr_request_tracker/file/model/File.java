package com.example.hr_request_tracker.hr_request_tracker.file.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.ticket.model.Ticket;

@Entity
@Table(name="file")
public class File {
	@Id
	@Column(name="file_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fileID;
	@Column(name="file_name")
	private String fileName;
	@Column(name="file_type")
	private String fileType;
	
	@Lob
	@Column(name="file_data")
	private byte[] fileData;
	
	@OneToMany(mappedBy="file", cascade = CascadeType.ALL)
	private Set<Ticket> tickets;
	
	public File() {}
	
	public File(String fileName, String fileType, byte[] fileData) {
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public int getFileID() {
		return fileID;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public byte[] getFileData() {
		return fileData;
	}
	
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
