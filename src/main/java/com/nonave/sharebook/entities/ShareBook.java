package com.nonave.sharebook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sharebook")
public class ShareBook {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="author")
	private String author;
	@Column(name="url")
	private String url;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="status")
	private boolean status;
	@Column(name="content")
	private String content;


}

