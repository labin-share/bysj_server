package dto;

import java.util.List;

import entity.SheetImge;

public class SheetEvalDTO {

	private String evaluation;
	private String type;
	private int Attitude;
	private int speed;
	private String evaTime;
	private boolean isEva;
	private int achive;
	private List<SheetImge> sheetImgList;

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getEvaTime() {
		return evaTime;
	}

	public void setEvaTime(String evaTime) {
		this.evaTime = evaTime;
	}

	public boolean isEva() {
		return isEva;
	}

	public void setEva(boolean isEva) {
		this.isEva = isEva;
	}

	public int getAchive() {
		return achive;
	}

	public void setAchive(int achive) {
		this.achive = achive;
	}

	public List<SheetImge> getSheetImgList() {
		return sheetImgList;
	}

	public void setSheetImgList(List<SheetImge> sheetImgList) {
		this.sheetImgList = sheetImgList;
	}

}
