package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;

import java.util.List;

public interface PatientRepository extends CrudRepository<PatientEntity, Long> {
    List<PatientEntity> findAllByLastName(String lastName);
    List<PatientEntity> findAll();
}
