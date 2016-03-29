package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CHARGEBACK_IMG")
public class ChargebackImge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@ManyToOne
	@JoinColumn(name = "CHARGEBACK_ID", referencedColumnName = "ID")
	@JsonIgnore
	private Chargeback chargebackId;
	@Column(name = "img")
	private String img;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chargeback getSheetId() {
		return chargebackId;
	}

	public void setSheetId(Chargeback chargebackId) {
		this.chargebackId = chargebackId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
