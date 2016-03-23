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
@Table(name = "SHEET")
public class Sheet extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@Column(name = "CUSTOMER_ID", length = 3, nullable = false)
	private int customerId;
	@Column(name = "MTNER_ID", length = 3, nullable = true)
	private int mtnerId;
	// @OneToOne(optional = false)
	// @JoinColumn(name = "CONTACT_ID", unique = true, nullable = false,
	// updatable = false)
	// private Contaction contaction;
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	@Column(name = "PHONE", nullable = false)
	private String phone;
	@Column(name = "EXPECTIVE_TIME", nullable = false)
	private String expectiveTime;
	@Column(name = "STATE")
	private int state;
	@Column(name = "TYPE", length = 3)
	private int type;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "EVALUATION")
	private String evaluation;
	@Column(name = "ATTITUDE")
	private int Attitude;
	@Column(name = "MTN_SPEED")
	private int speed;
	// @Column(name = "RESONABLE_PRICE")
	// private int resonablePrice;
	@Column(name = "END_TIME")
	private String endTime;
	@Column(name = "EVA_TIME")
	private String evaTime;
	@Column(name = "IS_ENABLE_EVA")
	private boolean isEnableEva;
	@Column(name = "ACHIEVE")
	private int achive;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sheetId")
	@JoinColumn(name = "ID", referencedColumnName = "SHEET_ID")
	private List<SheetStateFollow> sheetStateList;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sheetId")
	@JoinColumn(name = "ID", referencedColumnName = "SHEET_ID")
	private List<SheetProgress> sheetProgressList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getMtnerId() {
		return mtnerId;
	}

	public void setMtnerId(int mtnerId) {
		this.mtnerId = mtnerId;
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

	public String getExpectiveTime() {
		return expectiveTime;
	}

	public void setExpectiveTime(String expectiveTime) {
		this.expectiveTime = expectiveTime;
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

	// public int getResonablePrice() {
	// return resonablePrice;
	// }
	//
	// public void setResonablePrice(int resonablePrice) {
	// this.resonablePrice = resonablePrice;
	// }

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

	public List<SheetStateFollow> getSheetStateList() {
		return sheetStateList;
	}

	public void setSheetStateList(List<SheetStateFollow> sheetStateList) {
		this.sheetStateList = sheetStateList;
	}

}
