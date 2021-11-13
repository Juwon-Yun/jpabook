package jpabook;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity{

	@Id @GeneratedValue
	@Column(name = "Delivery_ID")
	private Long id;

	private String city;
	private String street;
	private String zipcode;
	private DeliveryStatus status;
	
	// 일대일 양방향
	@OneToOne(mappedBy = "delivery")
	private Order order;
}
