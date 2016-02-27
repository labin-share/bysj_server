package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TEST")
public class Test extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
