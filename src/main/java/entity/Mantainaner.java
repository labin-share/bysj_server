package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MANTAINANER")
public class Mantainaner extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID", length = 4)
	private int id;
	@Column(name = "PHONE", unique = true, length = 11, nullable = false)
	private String phone;
	@Column(name = "USER_NAME", unique = true, length = 250, nullable = false)
	private String name;
	@Column(name = "PSW", nullable = false)
	private String psw;
	@Column(name = "HEAD_PORTRAIT", nullable = true)
	private String headPortrait;
	@Column(name = "ADDRESS", nullable = true)
	private String address;
	@Column(name = "SIGNATURE", nullable = true)
	private String signature;
	@Column(name = "CREDIT", nullable = true)
	private String credit;
	@Column(name = "EVA_NUM", nullable = true)
	private int evaNum;
	@OneToMany(cascade = CascadeType .ALL)
	@JoinColumn(name = "MTN_ID")
	private List<MantainType> mantainTypeList; 

}
