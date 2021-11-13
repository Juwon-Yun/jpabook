package jpabook.domain;

import jpabook.Book;
import jpabook.Order;
import jpabook.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
	실전예제3
	 - 테이블의 N:M 관계는 중간 테이블을 이용해서 1:N, N:1
	 - 실전에서는 중간 테이블이 단순하지 않다.
	 - @ManyToMany는 제약: 필드 추가X, 엔티티 테이블 불일치
	 - 실전에서는 @ManyToMany 사용X
    
    @JoinColimn (외래 키 제약조건을 매핑하는 것이 아니라, 외래 키를 매핑하는 것임)
     - 외래 키를 매핑할 때 사용
     - name 매핑할 외래 키 이름
     - referencedColumnName 외래 키가 참조하는 대상 테이블의 컬럼명
     - foreignKey(DDL) 외래 키 제약 조건을 직접 지정할 수 있다. 이 속성은 테이블을 생성할 때만 사용한다.
     - 이외 @Column의 속성과 같다.

    @ManyToOne의 주요 속성
     - optional false로 설정하면 연관된 엔티티가 항상 있어야 한다.
     - fetch 글로벌 패치 전략을 설정한다.
     - cascade 영속성 전이 기능을 사용한다.
     - targetEntity 연관된 엔티티의 타입 정보를 설정한다. 이 기능은 거의 사용하지 않는다. 컬렉션의 제네틱으로 타입 정보를 알 수 있다.

     @OneToMany 주요 속성 (다대일 관계 매핑)
      - mappedBy 연관관계의 주인 필드를 선택한다.
      - fetch 글로벌 페치 전략을 설정한다 ex)
        => @ManyToOne = FetchType.EAGER
        => @OneToMany = FetchType.LAZY
      - cascade 영속성 전이 기능을 사용한다.
      - targetEntity 연관된 엔티티의 타입 정보를 설정한다. 거의 사용하지 않고, 컬렉션의 제네틱으로 타입 정보를 알 수 있다.

	h2 sql => DROP ALL OBJECTS 모든 테이블 DROP

 */
public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
//			Order order = new Order();
//			em.persist(order);
//
//			// 굳이 양방향을 만든다면 (조회, JPQL을 편하게 쓰려면 만들수도 있다)
//			// order.addOrderItem(new OrderItem());
//
//			OrderItem orderItem = new OrderItem();
//			orderItem.setOrder(order);
//
//			em.persist(orderItem);

			Book book = new Book();
			book.setName("JPA_basic");
			book.setAuthor("윤주원2");
			em.persist(book);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
