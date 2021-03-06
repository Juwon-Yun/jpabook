package jpabook;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class OrderItem extends BaseEntity{
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private long id;

//	@Column(name = "ORDER_ID")
//	private long orderId;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

//	@Column(name = "ITEM_ID")
//	private long itemId;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
