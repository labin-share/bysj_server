package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATAIN_TYPE")
public class MantainType extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID", length = 4)
	private int id;
	@Column(name = "MTN_ID", nullable = false)
	private int mtnId;
	@Column(name = "TAG", nullable = false)
	private String tag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMtnId() {
		return mtnId;
	}

	public void setMtnId(int mtnId) {
		this.mtnId = mtnId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
