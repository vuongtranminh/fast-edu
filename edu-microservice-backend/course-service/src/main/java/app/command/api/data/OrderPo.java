package app.command.api.data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Date;
import java.util.Date;

public class OrderPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String note;
	private String address;
	private Date paymentedAt;
	private BigDecimal totalPrice;
	private String city;
	private String commune;
	private String buyerName;
	private Date createdAt;
	private Long buyerId;
	private Byte isDeleted;
	private Date updatedAt;
	private String phone;
	private String district;
	private Long id;
	private Date deliveredAt;
	private Byte status;


	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	public Date getPaymentedAt() {
		return paymentedAt;
	}
	public void setPaymentedAt(Date paymentedAt) {
		this.paymentedAt = paymentedAt;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune == null ? null : commune.trim();
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName == null ? null : buyerName.trim();
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDeliveredAt() {
		return deliveredAt;
	}
	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}

}