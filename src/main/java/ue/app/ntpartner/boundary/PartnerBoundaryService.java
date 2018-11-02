package ue.app.ntpartner.boundary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ue.app.ntpartner.model.Partner;

public interface PartnerBoundaryService {

    Partner createPartner(Partner partner);

    Page<Partner> findAllPartner(Pageable pageable);

    Partner getPartnerById(Long id);

    void deletePartner(Long id);
}
