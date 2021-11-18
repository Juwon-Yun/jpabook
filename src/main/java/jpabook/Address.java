package jpabook;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

// Value Type
@Embeddable
public class Address {

	@Column(length = 10)
	private String city;
	@Column(length = 20)
	private String street;
	@Column(length = 5)
	private String zipcode;

	public String fullAddress(){
		return getCity() + " " + getStreet() + " " + getZipcode();
	}

	private void setCity(String city) {
		this.city = city;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getZipcode() {
		return zipcode;
	}
	
	// use getters during code generation 을 체크하는게 좋다
	// 선택하지 않으면 필드에 직접 접근한다 
	// 단점 => 필드에 바로 접근하면 프록시일 때 구분할 수 없다.
	// getter가 아니더라도 접근할 수 있는 메소드로 구성하는것이 실무에서 사용하는 방법

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipcode());
	}
}
