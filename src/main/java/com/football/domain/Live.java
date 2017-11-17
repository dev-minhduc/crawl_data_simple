package com.football.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "livestream")
public class Live implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_live", nullable = false)
	private int id_live;
	
	@NotEmpty
	@Column(name = "title_live", nullable = false)
	private String title_live;
	
	@NotEmpty
	@Column(name = "link_live", nullable = false)
	private String link_live;
	
	@NotEmpty
	@Column(name = "thumbnail_team1_live", nullable = false)
	private String thumbnail_team1_live;
	
	@NotEmpty
	@Column(name = "thumbnail_team2_live", nullable = false)
	private String thumbnail_team2_live;
	
	@Column(name = "status_live")
	private boolean status_live;

	public int getId_live() {
		return id_live;
	}

	public void setId_live(int id_live) {
		this.id_live = id_live;
	}

	public String getTitle_live() {
		return title_live;
	}

	public void setTitle_live(String title_live) {
		this.title_live = title_live;
	}

	public String getLink_live() {
		return link_live;
	}

	public void setLink_live(String link_live) {
		this.link_live = link_live;
	}

	public String getThumbnail_team1_live() {
		return thumbnail_team1_live;
	}

	public void setThumbnail_team1_live(String thumbnail_team1_live) {
		this.thumbnail_team1_live = thumbnail_team1_live;
	}

	public String getThumbnail_team2_live() {
		return thumbnail_team2_live;
	}

	public void setThumbnail_team2_live(String thumbnail_team2_live) {
		this.thumbnail_team2_live = thumbnail_team2_live;
	}

	public boolean isStatus_live() {
		return status_live;
	}

	public void setStatus_live(boolean status_live) {
		this.status_live = status_live;
	}

	public Live(int id_live, String title_live, String link_live, String thumbnail_team1_live,
			String thumbnail_team2_live, boolean status_live) {
		super();
		this.id_live = id_live;
		this.title_live = title_live;
		this.link_live = link_live;
		this.thumbnail_team1_live = thumbnail_team1_live;
		this.thumbnail_team2_live = thumbnail_team2_live;
		this.status_live = status_live;
	}

	public Live() {
		super();
	}
	
	
	
}
