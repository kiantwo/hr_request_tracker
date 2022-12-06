package com.example.hr_request_tracker.hr_request_tracker.file.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.hr_request_tracker.hr_request_tracker.file.model.File;

public interface IFileService {
	public Optional<File> findById(final int id);
	public File save(final MultipartFile file) throws IOException;
	public Integer delete(final int id) throws Exception;
}
