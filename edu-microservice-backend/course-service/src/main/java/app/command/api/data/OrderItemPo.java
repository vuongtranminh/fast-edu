package app.command.api.data;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItemPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long variantId;
	private Integer quantity;
	private BigDecimal price;
	private Long id;
	private Long orderId;


	public Long getVariantId() {
		return variantId;
	}
	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}