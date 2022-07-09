package com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="videos")
public class Video implements Serializable  {
	
		@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;

	private String observation;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	
	@JsonIgnoreProperties(value={"videos", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Proyect proyect;
	
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "video_id")
	private List<ItemVideo> items;
	
	
	public Video() {
		items = new ArrayList<>();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {	
		
		this.id = id;
	}

		
	@JoinColumn(name = "video_url")
	private String videoUrl; 
	
	public String getDescription() {
		return description;
	}

	
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Proyect getProyect() {
		return proyect;
	}

	public void setProyect(Proyect proyect) {
		this.proyect = proyect;
	} 
	
	
	public List<ItemVideo> getItems() {
		return items;
	}
	public void setItems(List<ItemVideo> items) {
		this.items = items;
	}


	public Double getTotal() {
		Double total = 0.00;
		for (ItemVideo item : items) {
			total += item.getAmount();
		}
		return total;
	}
	private static final long serialVersionUID = 1L;

	

}
