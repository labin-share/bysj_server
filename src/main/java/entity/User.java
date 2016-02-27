package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"USER_TYPE", "USER_NAME" }) })
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID", length = 4)
	private int id;
	@Column(name = "USER_TYPE", length = 3, nullable = false)
	private String type;
	@Column(name = "PHONE", length = 11, nullable = false)
	private String phone;
	@Column(name = "USER_NAME", length = 250)
	private String name = phone;
	@Column(name = "PSW", nullable = false)
	private String psw;
	@Column(name = "HEAD_PORTRAIT", nullable = true)
	private String headPortrait;
	@Column(name = "ADDRESS", nullable = true)
	private String address;
	@Column(name = "SIGNATURE", nullable = true)
	private String signature;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
