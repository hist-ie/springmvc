package org.houor.spring.rest.domain;

import java.util.Date;

public class Spittle {

	private Long id;
	private String message;
	private Date time;
	private Double longitude;
	private Double latitude;

	public Spittle(String message, Date time) {
		this(null, message, time, null, null);
	}

	public Spittle(Long id, String message, Date time) {
		this(id, message, time, null, null);
	}

	public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
