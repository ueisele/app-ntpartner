package ue.app.ntpartner.api.resource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import ue.app.ntpartner.model.Partner;

public class PartnerResourceAssembler extends ResourceAssemblerSupport<Partner, PartnerResource> {

	public PartnerResourceAssembler(Class<?> controllerClass, Class<PartnerResource> resourceType) {
		super(controllerClass, resourceType);
	}

	@Override
	public PartnerResource toResource(Partner partner) {
		PartnerResource partnerResource = createResourceWithId(partner.getId(), partner);
		partnerResource.id = partner.getId();
		if(partner.getName() != null) {
			partnerResource.name = partner.getName().firstname + " " + partner.getName().lastname;
		}
		if (partner.getAddress() != null) {
			partnerResource.address = new AddressResource();
			partnerResource.address.city = partner.getAddress().city;
			partnerResource.address.zipCode= partner.getAddress().zipCode;
			partnerResource.address.street = partner.getAddress().street;
			partnerResource.address.streetNo=partner.getAddress().streetNo;
		}
		return partnerResource;
	}

}
