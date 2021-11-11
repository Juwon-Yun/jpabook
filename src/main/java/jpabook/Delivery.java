package jpabook;

import javax.persistence.*;

@Entity
public class Delivery {

	@Id @GeneratedValue
	private Long id;

	private String city;
	private String street;
	private String zipcode;
	private DeliveryStatus status;
	
	// 일대일 양방향
	@OneToOne(mappedBy = "Delivery_ID")
	private Order order;
}
