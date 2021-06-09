package pl.wsiz.iid6.gr2.patientservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;

import java.util.Optional;
import java.util.List;
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Pacjent findbyId(Long id) {
        Optional<PatientEntity> res = patientRepository.findById(id);
        if (res.isPresent()) {
            PatientEntity pat = res.get();
            return new Pacjent(pat.getFirstName(),pat.getLastName(),pat.getPesel(), pat.getNrUbezpieczenia() );
        }
        return new Pacjent("None", "None", "04312016839");
    }
    public String findByLastName(String name){

        List<PatientEntity> rs = patientRepository.findAllByLastName(name);
        return rs.toString();
    }
    public List<PatientEntity> findAll(){
        List<PatientEntity> rs =  patientRepository.findAll();
        return rs;
    }
}
