package app.command.api.data;

import java.io.Serializable;
import java.util.Date;
import java.util.Date;

public class ProductPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Byte isDeleted;
	private Long categoryId;
	private Date updatedAt;
	private String image02;
	private String image01;
	private String description;
	private Date createdAt;
	private Long id;
	private String productName;


	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getImage02() {
		return image02;
	}
	public void setImage02(String image02) {
		this.image02 = image02 == null ? null : image02.trim();
	}
	public String getImage01() {
		return image01;
	}
	public void setImage01(String image01) {
		this.image01 = image01 == null ? null : image01.trim();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

}