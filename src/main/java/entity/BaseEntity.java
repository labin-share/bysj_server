package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import common.TimeAssistant;

import constant.ComConstant;

@MappedSuperclass
public class BaseEntity {

	@Column(name = "CREATE_DATE")
	protected String createDate;

	@Column(name = "LAST_UPDATE_DATE")
	protected String lastUpdateDate;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@PrePersist
	public void setDefaultDateTime() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(TimeAssistant.BACKEND_TIME_FORMAT);
		this.createDate = df.format(d);
		this.lastUpdateDate = df.format(d);
	}

	@PreUpdate
	public void setUpdateDateTime() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(TimeAssistant.BACKEND_TIME_FORMAT);
		this.lastUpdateDate = df.format(d);
	}
}
