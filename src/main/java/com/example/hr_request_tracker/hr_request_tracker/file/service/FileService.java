package com.example.hr_request_tracker.hr_request_tracker.file.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.hr_request_tracker.hr_request_tracker.file.model.File;
import com.example.hr_request_tracker.hr_request_tracker.file.repository.IFileRepository;

@Service
public class FileService implements IFileService {
	@Autowired
	private IFileRepository repository;
	
	public Optional<File> findById(final int id) {
		return repository.findById(id);
	}
	
	public File save(final MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		File savedFile = new File(fileName, file.getContentType(), file.getBytes());
		
		return repository.save(savedFile);
	}
	
	public Integer delete(final int id) throws Exception {
		try {
			repository.deleteById(id);
			return 1;
		} catch(EmptyResultDataAccessException e) {
			return 0;
			
		}
	}
}
