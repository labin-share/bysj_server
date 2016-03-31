package dto;

public class CustomerDTO {
	private int id;
	private String phone;
	private String name;
	private String headPortrait;
	private String signature;
	private String oldPsw;
	private String newPsw;

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

	public String getOldPsw() {
		return oldPsw;
	}

	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

}
