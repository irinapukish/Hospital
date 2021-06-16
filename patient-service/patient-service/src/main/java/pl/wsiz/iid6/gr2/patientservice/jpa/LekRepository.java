package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;

import java.util.List;

public interface LekRepository  extends CrudRepository<LekEntity, Long> {
    List<LekEntity> findAll();
    List<LekEntity> findByNazwa(String nazwa);
    List<LekEntity> findByProducent(String producent);
}
