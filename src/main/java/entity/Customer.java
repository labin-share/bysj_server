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
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CUSTOMER_ID", length = 4)
	private int id;
	@Column(name = "PHONE", unique = true, length = 11, nullable = false)
	private String phone;
	@Column(name = "NAME", unique = true, length = 250, nullable = false)
	private String name = this.phone;
	@Column(name = "PSW", nullable = false)
	private String psw;
	@Column(name = "HEAD_PORTRAIT", nullable = true)
	private String headPortrait;
	@Column(name = "SIGNATURE", nullable = true)
	private String signature;
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customerId")
//	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
//	private List<Contaction> contactinList;

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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
