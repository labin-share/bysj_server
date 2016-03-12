package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MANTAINER")
public class Mantainer extends BaseEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "MTN_ID", length = 4)
	private int id;
	@Column(name = "PHONE", unique = true, length = 11, nullable = false)
	private String phone;
	@Column(name = "NAME", unique = true, length = 250, nullable = false)
	private String name;
	@Column(name = "PSW", nullable = false)
	private String psw;
	@Column(name = "HEAD_PORTRAIT", nullable = true)
	private String headPortrait;
	@Column(name = "ADDRESS", nullable = true)
	private String address;
	@Column(name = "SIGNATURE", nullable = true)
	private String signature;
	@Column(name = "CREDIT", nullable = true)
	private int credit = 5;
	@Column(name = "EVA_NUM", nullable = true)
	private int evaNum;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mtnId")
	@JoinColumn(name = "MTN_ID", referencedColumnName = "MTN_ID")
//	@JoinColumn(name = "MTN_ID")
	private List<MantainType> mantainTypeList;

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

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
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

}
