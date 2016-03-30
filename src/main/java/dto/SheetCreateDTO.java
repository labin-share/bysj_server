package dto;

public class SheetCreateDTO {

	private int id;
	private int customerId;
	private int mtnId;
	private String address;
	private String phone;
	private String expectiveTime;
	private String type;

	
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

	public int getMtnerId() {
		return mtnId;
	}

	public void setMtnerId(int mtnerId) {
		this.mtnId = mtnerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExpectiveTime() {
		return expectiveTime;
	}

	public void setExpectiveTime(String expectiveTime) {
		this.expectiveTime = expectiveTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
