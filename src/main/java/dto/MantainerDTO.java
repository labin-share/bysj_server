package dto;

import java.io.Serializable;
import java.util.List;

import entity.MantainType;

public class MantainerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String phone;
	private String name;
	// private String headPortrait;
	private String address;
	private String signature;
	private int evaNum;
	private int credit;
	private List<MantainType> mantainTypeList;
	private double distance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public String getHeadPortrait() {
	// return headPortrait;
	// }
	//
	// public void setHeadPortrait(String headPortrait) {
	// this.headPortrait = headPortrait;
	// }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getEvaNum() {
		return evaNum;
	}

	public void setEvaNum(int evaNum) {
		this.evaNum = evaNum;
	}

	public List<MantainType> getMantainTypeList() {
		return mantainTypeList;
	}

	public void setMantainTypeList(List<MantainType> mantainTypeList) {
		this.mantainTypeList = mantainTypeList;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
