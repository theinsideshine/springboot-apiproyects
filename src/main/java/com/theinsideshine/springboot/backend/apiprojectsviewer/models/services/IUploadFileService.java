package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	
	public Resource load(String imageName) throws MalformedURLException;
	public String copy(MultipartFile file) throws IOException;
	public boolean delete(String imageName);
	public Path getPath(String imageName);

}
