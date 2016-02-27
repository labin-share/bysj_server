package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_COLL")
public class CustomerCollection extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int customerId;
	@Column(name = "MANTAINER_ID", nullable = false)
	private int mantainerId;
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
	public int getMantainerId() {
		return mantainerId;
	}
	public void setMantainerId(int mantainerId) {
		this.mantainerId = mantainerId;
	}

}
