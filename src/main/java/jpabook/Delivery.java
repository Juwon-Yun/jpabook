package jpabook;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

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
	@OneToOne(mappedBy = "delivery", fetch = LAZY)
	private Order order;
}
