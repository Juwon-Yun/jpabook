package jpabook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;

//	private String city;
//	private String zipcode;
	
	// 명확한 값 타입 명시
	@Embedded
	private Address address;

	// 만약에 양방향 관계를 가져가고싶은 경우
	@OneToMany(mappedBy = "member")
	private List<Order> oders = new ArrayList<>();

	public List<Order> getOders() {
		return oders;
	}

	public void setOders(List<Order> oders) {
		this.oders = oders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getZipcode() {
//		return zipcode;
//	}
//
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
}
