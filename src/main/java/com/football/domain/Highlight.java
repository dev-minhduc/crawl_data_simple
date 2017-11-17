package com.football.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "highlight")
public class Highlight implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hl", nullable = false)
	private int id_hl;
	
	@NotEmpty
	@Column(name = "title_hl", nullable = false)
	private String title_hl;
	
	@NotEmpty
	@Column(name = "img_hl", nullable = false)
	private String img_hl;
	
	@NotEmpty
	@Column(name = "link_hl", nullable = false)
	private String link_hl;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_hl")
	private Date date_hl;
	
	@Column(name = "status_hl")
	private boolean status_hl;

	public int getId_hl() {
		return id_hl;
	}

	public void setId_hl(int id_hl) {
		this.id_hl = id_hl;
	}

	public String getTitle_hl() {
		return title_hl;
	}

	public void setTitle_hl(String title_hl) {
		this.title_hl = title_hl;
	}

	public String getImg_hl() {
		return img_hl;
	}

	public void setImg_hl(String img_hl) {
		this.img_hl = img_hl;
	}

	public String getLink_hl() {
		return link_hl;
	}

	public void setLink_hl(String link_hl) {
		this.link_hl = link_hl;
	}

	public Date getDate_hl() {
		return date_hl;
	}

	public void setDate_hl(Date date_hl) {
		this.date_hl = date_hl;
	}

	public boolean isStatus_hl() {
		return status_hl;
	}

	public void setStatus_hl(boolean status_hl) {
		this.status_hl = status_hl;
	}

	public Highlight( String title_hl, String img_hl, String link_hl, Date date_hl, boolean status_hl) {
		super();
		this.title_hl = title_hl;
		this.img_hl = img_hl;
		this.link_hl = link_hl;
		this.date_hl = date_hl;
		this.status_hl = status_hl;
	}

	public Highlight() {
		
	}
	
	
	
}
