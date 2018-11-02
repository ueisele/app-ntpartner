package ue.app.ntpartner.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ue.app.ntpartner.api.PartnerController;
import ue.app.ntpartner.common.PageLinks;
import ue.app.ntpartner.model.Partner;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PartnerListResourceAssembler {

	@PageLinks(PartnerController.class)
	public ListResource<PartnerResource> build(Page<Partner> page) {
		List<PartnerResource> personList = page.getContent().stream().map((person)->{
			PartnerResourceAssembler assembler = new PartnerResourceAssembler(PartnerController.class, PartnerResource.class);
			PartnerResource resource = assembler.toResource(person);
			return resource;
		}).collect(Collectors.toList());
		ListResource<PartnerResource> listResource = new ListResource<>(personList);
		return listResource;
	}

}
