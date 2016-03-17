package dto;

public class CustomerDTO {
	private int id;
	private String phone;
	private String name;
//	private String headPortrait;
	private String signature;

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

//	public String getHeadPortrait() {
//		return headPortrait;
//	}
//
//	public void setHeadPortrait(String headPortrait) {
//		this.headPortrait = headPortrait;
//	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
