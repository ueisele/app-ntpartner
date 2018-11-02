package ue.app.ntpartner.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Name implements Serializable {

	private static final long serialVersionUID = -6618518558405876350L;

	@NotBlank
	public String firstname;

	@NotBlank
	public String lastname;

	public Name() {
	}

	public Name(@NotBlank String firstname, @NotBlank String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name = (Name) o;
		return Objects.equals(firstname, name.firstname) &&
				Objects.equals(lastname, name.lastname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname);
	}

	@Override
	public String toString() {
		return "Name{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				'}';
	}
}
