package cc.geekie.domain;

import java.io.Serializable;

public class GpsInfo implements Serializable {

	@Override
	public String toString() {
		return "GpsInfo [id=" + id + ", longitude=" + longitude + ", latitude="
				+ latitude + ", time=" + time + ", startTime=" + startTime
				+ "]";
	}

	private String id;
	private String longitude;
	private String latitude;
	private String time;
	private String startTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public GpsInfo(String id, String longitude, String latitude, String time,
			String startTime) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.time = time;
		this.startTime = startTime;
	}

	public GpsInfo() {}
}
