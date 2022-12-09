package com.example.hr_request_tracker.hr_request_tracker.file.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hr_request_tracker.hr_request_tracker.common.models.ApiResponse;
import com.example.hr_request_tracker.hr_request_tracker.file.messages.FileMessages;
import com.example.hr_request_tracker.hr_request_tracker.file.model.File;
import com.example.hr_request_tracker.hr_request_tracker.file.service.IFileService;

@RestController
public class FileController {
	@Autowired
	private IFileService service;
	
	@RequestMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable int id) {
		Optional<File> file = service.findById(id);
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" 
				+ file.get().getFileName() + "\"").body(file.get().getFileData());
	}
	
	@PostMapping("/upload")
	public ApiResponse upload(@RequestParam("file") MultipartFile file) throws IOException {
		File savedFile = service.save(file);
		
		if(savedFile != null) {
			return ApiResponse.CreateSuccess(savedFile, FileMessages.FILE_SUCCESSFULLY_SAVED);
		}
		
		return ApiResponse.CreateError(FileMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
}
