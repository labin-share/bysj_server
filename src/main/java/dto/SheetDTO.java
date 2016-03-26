package dto;

import java.util.List;

import entity.SheetImge;

public class SheetDTO {
	private int id;
	private String address;
	private String phone;
	private int state;
	private int type;
	private String content;
	private String evaluation;
	private int Attitude;
	private int speed;
	private String createDate;
	private String endTime;
	private String evaTime;
	private boolean isEnableEva;
	// private int achive;
	// private List<SheetStateFollow> sheetStateList;
	// private List<SheetProgress> sheetProgressList;
	private List<SheetImge> SheetImgList;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
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

	// public int getAchive() {
	// return achive;
	// }
	//
	// public void setAchive(int achive) {
	// this.achive = achive;
	// }
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

}
