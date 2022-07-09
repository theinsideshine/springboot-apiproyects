package com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Video;

public interface IVideoDao  extends CrudRepository<Video, Long> {
	

}
