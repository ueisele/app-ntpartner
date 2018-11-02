package ue.app.ntpartner.boundary.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ue.app.ntpartner.boundary.PartnerBoundaryService;
import ue.app.ntpartner.model.Partner;
import ue.app.ntpartner.repository.PartnerRepository;

@Service
@Transactional
public class PartnerBoundaryServiceImpl implements PartnerBoundaryService {

	private static final Pageable DEFAULT_PAGEABLE = PageRequest.of(0, 10);

	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public Partner createPartner(Partner partner) {
		Partner newPartner = null;
		if (partner != null) {
			newPartner = partnerRepository.save(partner);
		}
		return newPartner;
	}

	@Override
	public Page<Partner> findAllPartner(Pageable pageable) {
		if (pageable == null) {
			pageable = DEFAULT_PAGEABLE;
		}
		return partnerRepository.findAll(pageable);
	}

	@Override
	public Partner getPartnerById(Long id) {
		return partnerRepository.getOne(id);
	}

	@Override
	public void deletePartner(Long id) {
		partnerRepository.deleteById(id);
	}

}
