package jpabook;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERS")
public class Order  extends BaseEntity{

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;
	
	/*
	    이런 설계는 객체지향스럽지않고 관계형 DB에 맞춰서 설계한것
	    현재 방식은 객체 설계를 테이블 설계에 맞춘 방식
	    테이블의 외래키를 객체에 그대로 가져옴
	    객체 그래프 탐색이 불가능
	    참조가 없으므로 UML도 잘못됨
	 */
//	@Column(name = "MEMBER_ID")
//	private Long memberId;
// order를 생성할때 items, delivery가 자동으로 생김

	// MEMBER_ID(FK)
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Delivery_ID")
	private Delivery delivery;

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
