package ue.app.ntpartner.api.resource;

import org.springframework.hateoas.ResourceSupport;
import ue.app.ntpartner.model.Address;
import ue.app.ntpartner.model.Name;
import ue.app.ntpartner.model.Partner;

public class PartnerResource extends ResourceSupport {

	public static String NAME_DELIMITER = " ";
	
	public Long id;
    public String name;
    public AddressResource address;

    public Partner toPartner() {
        Partner partner = new Partner(this.id);
        int delimiter = this.name.indexOf(NAME_DELIMITER);
        if (delimiter != -1) {
            partner.setName(new Name(this.name.substring(0, delimiter), this.name.substring(delimiter + 1)));
        }
        if (this.address != null) {
            Address address = new Address();
            address.city = this.address.city;
            address.zipCode = this.address.zipCode;
            address.street = this.address.street;
            address.streetNo = this.address.streetNo;
            partner.setAddress(address);
        }
        return partner;
    }
}
