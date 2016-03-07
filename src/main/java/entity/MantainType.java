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
@Table(name = "MANTAIN_TYPE")
public class MantainType extends BaseEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@ManyToOne
	@JoinColumn(name = "MTN_ID", referencedColumnName = "MTN_ID")
	@JsonIgnore
//	@Column(name = "MTN_ID", nullable = false)
	private Mantainer mtnId;
	@Column(name = "TAG", nullable = false)
	private String tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mantainer getMtnId() {
		return mtnId;
	}

	public void setMtnId(Mantainer mtnId) {
		this.mtnId = mtnId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
