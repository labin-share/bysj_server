package dto;

import java.util.List;

import entity.ChargebackImge;
import entity.SheetImge;

public class SheetDTO {
	private int id;
	private String address;
	private double longitude;
	private double latitude;
	private double distance;
	private String phone;
	private int state;
	private String type;
	private String content;
	private String evaluation;
	private int Attitude;
	private int speed;
	private String expectiveTime;
	private String createDate;
	private String endTime;
	private String evaTime;
	private boolean isEnableEva;
	private int achive;
	// private List<SheetStateFollow> sheetStateList;
	// private List<SheetProgress> sheetProgressList;
	private List<SheetImge> SheetImgList;

	private int chargebackId;
	private int chargebackState;
	private int chargebackReason;
	private String chargebackContent;
	private List<ChargebackImge> chargebackImgeList;
	private String chargebackTime;

	private String lastStateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public int getAttitude() {
		return Attitude;
	}

	public void setAttitude(int attitude) {
		Attitude = attitude;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getExpectiveTime() {
		return expectiveTime;
	}

	public void setExpectiveTime(String expectiveTime) {
		this.expectiveTime = expectiveTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEvaTime() {
		return evaTime;
	}

	public void setEvaTime(String evaTime) {
		this.evaTime = evaTime;
	}

	public boolean isEnableEva() {
		return isEnableEva;
	}

	public void setEnableEva(boolean isEnableEva) {
		this.isEnableEva = isEnableEva;
	}

	public int getAchive() {
		return achive;
	}

	public void setAchive(int achive) {
		this.achive = achive;
	}

	//
	// public List<SheetStateFollow> getSheetStateList() {
	// return sheetStateList;
	// }
	//
	// public void setSheetStateList(List<SheetStateFollow> sheetStateList) {
	// this.sheetStateList = sheetStateList;
	// }
	//
	// public List<SheetProgress> getSheetProgressList() {
	// return sheetProgressList;
	// }
	//
	// public void setSheetProgressList(List<SheetProgress> sheetProgressList) {
	// this.sheetProgressList = sheetProgressList;
	// }

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<SheetImge> getSheetImgList() {
		return SheetImgList;
	}

	public void setSheetImgList(List<SheetImge> sheetImgList) {
		SheetImgList = sheetImgList;
	}

	public int getChargebackId() {
		return chargebackId;
	}

	public void setChargebackId(int chargebackId) {
		this.chargebackId = chargebackId;
	}

	public int getChargebackState() {
		return chargebackState;
	}

	public void setChargebackState(int chargebackState) {
		this.chargebackState = chargebackState;
	}

	public int getChargebackReason() {
		return chargebackReason;
	}

	public void setChargebackReason(int chargebackReason) {
		this.chargebackReason = chargebackReason;
	}

	public String getChargebackContent() {
		return chargebackContent;
	}

	public void setChargebackContent(String chargebackContent) {
		this.chargebackContent = chargebackContent;
	}

	public List<ChargebackImge> getChargebackImgeList() {
		return chargebackImgeList;
	}

	public void setChargebackImgeList(List<ChargebackImge> chargebackImgeList) {
		this.chargebackImgeList = chargebackImgeList;
	}

	public String getChargebackTime() {
		return chargebackTime;
	}

	public void setChargebackTime(String chargebackTime) {
		this.chargebackTime = chargebackTime;
	}

	public String getLastStateTime() {
		return lastStateTime;
	}

	public void setLastStateTime(String lastStateTime) {
		this.lastStateTime = lastStateTime;
	}

}
