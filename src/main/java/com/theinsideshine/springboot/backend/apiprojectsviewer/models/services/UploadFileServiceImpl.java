package com.theinsideshine.springboot.backend.apiprojectsviewer.models.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

	private final static String DIRECTORIO_UPLOAD = "uploads";

	@Override
	public Resource load(String imageName) throws MalformedURLException {

		Path pathFile = getPath(imageName);
		log.info(pathFile.toString());

		Resource resource = new UrlResource(pathFile.toUri());

		if (!resource.exists() && !resource.isReadable()) {
			pathFile = Paths.get("src/main/resources/static/images").resolve("no-usuario.png").toAbsolutePath();

			resource = new UrlResource(pathFile.toUri());

			log.error("Error no se pudo cargar la imagen: " + imageName);
		}

		return resource;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		String nameFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");

		Path pathFile = getPath(nameFile);

		log.info(pathFile.toString());

		Files.copy(file.getInputStream(), pathFile);

		return nameFile;
	}

	@Override
	public boolean delete(String imageName) {
		
		if(imageName !=null && imageName.length() >0) {
			Path pathFilePrevius = Paths.get("uploads").resolve(imageName).toAbsolutePath();
			File fileImagePrevious = pathFilePrevius.toFile();
			if(fileImagePrevious.exists() && fileImagePrevious.canRead()) {
				fileImagePrevious.delete();
				return true;
			}
		}

		return false;
	}

	@Override
	public Path getPath(String imageName) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(imageName).toAbsolutePath();

	}

}
