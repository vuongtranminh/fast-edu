package app.command.api.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;

public class AddressPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String address;
	private Date updatedAt;
	private Long userId;
	private String city;
	private String phone;
	private String commune;
	private String district;
	private String name;
	private Date createdAt;
	private Long id;
	private Byte type;


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune == null ? null : commune.trim();
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}

}