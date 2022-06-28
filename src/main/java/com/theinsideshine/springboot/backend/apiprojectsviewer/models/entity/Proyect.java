package com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name="proyects")
public class Proyect implements Serializable{

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    	
    @NotEmpty(message ="no puede estar vacio")
    @Size(min=4, max=30, message="el tamaño tiene que estar entre 4 y 30")
    @Column(nullable=false, unique=true)
	private String name;

    @NotEmpty(message ="no puede estar vacio")
    @Size(min=4, max=50, message="el tamaño tiene que estar entre 4 y 50")
    private String intention;	
	
	@NotEmpty(message ="no puede estar vacio")
	private String technology;
	
	@NotEmpty(message ="no puede estar vacio")
	@Email(message="no es una dirección de correo bien formada")
	@Column(nullable=false)
	private String email;
	
	
	@NotNull(message= " no puede estar vacio")
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntention() {
		return intention;
	}

	public void setIntention(String intention) {
		this.intention = intention;
	}

	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}



	private static final long serialVersionUID = 1L;

}
