package ue.app.ntpartner.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ue.app.ntpartner.api.resource.ListResource;
import ue.app.ntpartner.api.resource.PartnerListResourceAssembler;
import ue.app.ntpartner.api.resource.PartnerResource;
import ue.app.ntpartner.api.resource.PartnerResourceAssembler;
import ue.app.ntpartner.boundary.PartnerBoundaryService;
import ue.app.ntpartner.model.Partner;

@RestController
@RequestMapping(value = "/v1/partner")
public class PartnerController {

	@Autowired
	private PartnerListResourceAssembler partnerListAssembler;

	public PartnerResourceAssembler getPartnerAssembler() {
		if (partnerAssembler == null) {
			partnerAssembler = new PartnerResourceAssembler(this.getClass(), PartnerResource.class);
		}
		return partnerAssembler;
	}

	private PartnerResourceAssembler partnerAssembler;

	@Autowired
	private PartnerBoundaryService partnerService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	public PartnerResource createPartner(@RequestBody PartnerResource partnerResource) {
		Partner partner = partnerResource.toPartner();
		Partner newPartner = partnerService.createPartner(partner);
		PartnerResource newPartnerResource =  this.getPartnerAssembler().toResource(newPartner);
		return newPartnerResource;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ListResource<PartnerResource> findAllPartner(Pageable pageable) {
		Page<Partner> page = partnerService.findAllPartner(pageable);
		ListResource<PartnerResource> partnerListResource = partnerListAssembler.build(page);
		return partnerListResource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PartnerResource getPartnerById(@PathVariable("id") Long id) {
		Partner partner = partnerService.getPartnerById(id);
		PartnerResourceAssembler assembler = new PartnerResourceAssembler(PartnerController.class, PartnerResource.class);
		PartnerResource resource = assembler.toResource(partner);
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePartner(@PathVariable("id") Long id) {
		System.out.println("delete called");
	    partnerService.deletePartner(id);
	}
}