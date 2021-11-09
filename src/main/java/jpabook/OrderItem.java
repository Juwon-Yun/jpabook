package jpabook;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private long id;
	@Column(name = "ORDER_ID")
	private long orderId;
	@Column(name = "ITEM_ID")
	private long itemId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
}
