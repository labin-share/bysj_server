package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String state;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "CONTENT")
	private String content;
	@Column(name = "EVALUATION")
	private String evaluation;
	@Column(name = "ATTITUDE")
	private int Attitude;
	@Column(name = "MTN_SPEED")
	private int speed;
	@Column(name = "RESONABLE_PRICE")
	private int resonablePrice;
	@Column(name = "END_TIME")
	private String endTime;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
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

	public int getResonablePrice() {
		return resonablePrice;
	}

	public void setResonablePrice(int resonablePrice) {
		this.resonablePrice = resonablePrice;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
