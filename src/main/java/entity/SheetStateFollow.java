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
@Table(name = "SHEET_STATE_FOLLOW")
public class SheetStateFollow extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@ManyToOne
	@JoinColumn(name = "SHEET_ID", referencedColumnName = "ID")
	@JsonIgnore
	private Sheet sheetId;
	@Column(name = "STATE")
	private int state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sheet getSheetId() {
		return sheetId;
	}

	public void setSheetId(Sheet sheetId) {
		this.sheetId = sheetId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
