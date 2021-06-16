package pl.wsiz.iid6.gr2.patientservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.LekRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LekService {
    @Autowired
    private LekRepository lekRepository;

    public Lek findById(Long id) {
        Optional<LekEntity> res = lekRepository.findById(id);
        if (res.isPresent()) {
            LekEntity lek = res.get();
            return new Lek(lek.getNazwa(),lek.getProducent(),lek.getIlosc());
        }
        return new Lek("None", "None", 0);
    }

    public List<LekEntity> findAll(){
        List<LekEntity> rs =  lekRepository.findAll();
        return rs;
    }

    public String findByNazwa(String nazwa){
        List<LekEntity> r = lekRepository.findByNazwa(nazwa);
        return r.toString();
    }
    public String findByProducent(String producent){
        List<LekEntity> rr = lekRepository.findByProducent(producent);
        return rr.toString();
    }
}

