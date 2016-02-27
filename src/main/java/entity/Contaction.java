package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTION")
public class Contaction extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID",length = 4)
	private int id;
	@Column(name = "CUSTOMER_ID",length = 4,nullable = false)
	private int customerId;
	@Column(name = "DEF",nullable = true)
	private boolean def;
	@Column(name = "ADDRESS",nullable = false)
	private String address;
	@Column(name = "PHONE",nullable = false)
	private String phone;

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

	public boolean isDef() {
		return def;
	}

	public void setDef(boolean def) {
		this.def = def;
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

}
