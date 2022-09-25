package app.command.api.data;

import java.io.Serializable;

public class ItemCartPo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer quantity;
	private Long variantId;
	private Long userId;
	private Long id;


	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getVariantId() {
		return variantId;
	}
	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}