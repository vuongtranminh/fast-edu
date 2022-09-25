package app.command.api.data;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;

public class VariantPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String image;
	private Integer quantity;
	private Byte isDeleted;
	private String color;
	private String size;
	private Date updatedAt;
	private BigDecimal price;
	private Long productId;
	private Date createdAt;
	private String variantName;
	private Long id;


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Byte getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color == null ? null : color.trim();
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size == null ? null : size.trim();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getVariantName() {
		return variantName;
	}
	public void setVariantName(String variantName) {
		this.variantName = variantName == null ? null : variantName.trim();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}