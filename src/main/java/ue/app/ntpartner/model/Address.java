package ue.app.ntpartner.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = -6503692835232524166L;

	public Address() {
	}

	public Address(@NotBlank String street, @NotBlank String streetNo, @NotBlank String zipCode, @NotBlank String city) {
		this.street = street;
		this.streetNo = streetNo;
		this.zipCode = zipCode;
		this.city = city;
	}

	@NotBlank
    public String street;
	
	@NotBlank
    public String streetNo;
	
	@NotBlank
    public String zipCode;
	
	@NotBlank
    public String city;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(street, address.street) &&
				Objects.equals(streetNo, address.streetNo) &&
				Objects.equals(zipCode, address.zipCode) &&
				Objects.equals(city, address.city);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, streetNo, zipCode, city);
	}

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", streetNo='" + streetNo + '\'' +
				", zipCode='" + zipCode + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
