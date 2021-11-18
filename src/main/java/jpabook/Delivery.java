package jpabook;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{

	@Id @GeneratedValue
	@Column(name = "Delivery_ID")
	private Long id;

	@Embedded
	private Address address;

	private DeliveryStatus status;

//	private String city;
//	private String street;
//	private String zipcode;

	// 일대일 양방향
	@OneToOne(mappedBy = "delivery", fetch = LAZY)
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
