package ue.app.ntpartner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ue.app.ntpartner.model.Partner;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    List<Partner> findByNameFirstname(String firstname);
    List<Partner> findByNameLastname(String lastname);
    List<Partner> findByNameFirstnameAndNameLastname(String firstname, String lastname);
}
