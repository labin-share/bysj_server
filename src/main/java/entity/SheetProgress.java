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
@Table(name = "SHEET_PROGRESS")
public class SheetProgress extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", length = 4)
	private int id;
	@ManyToOne
	@JoinColumn(name = "SHEET_ID", nullable = false)
	@JsonIgnore
	private Sheet sheetId;
	@Column(name = "CONTENT", nullable = false)
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
