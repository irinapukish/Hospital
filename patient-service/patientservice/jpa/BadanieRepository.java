package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.BadanieEntity;

import java.util.List;

public interface BadanieRepository extends CrudRepository<BadanieEntity, Long> {
    List<BadanieEntity> findAll();
}
