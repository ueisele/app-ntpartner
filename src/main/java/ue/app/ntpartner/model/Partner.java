package ue.app.ntpartner.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.Valid;
import java.io.Serializable;

@Entity
@Validated
public class Partner extends AbstractPersistable<Long> implements Identifiable<Long>, Serializable {

	private static final long serialVersionUID = -7728962437347271840L;

	@Valid
	@Embedded
	private Name name;

	@Valid
	@Embedded
	private Address address;

	public Partner() {
	}

	public Partner(@NonNull  Name name, @NonNull Address address) {
		this.name = name;
		this.address = address;
	}

	public Partner(Long id) {
		setId(id);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Partner{" +
				"name=" + name +
				", address=" + address +
				'}';
	}
}
