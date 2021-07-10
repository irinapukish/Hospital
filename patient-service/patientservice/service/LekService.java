package pl.wsiz.iid6.gr2.patientservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.LekRepository;


import java.util.ArrayList;
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
            return new Lek(lek.getNazwa(), lek.getProducent(), lek.getIlosc());
        }
        return new Lek("None", "None", 0);
    }

    public List<LekEntity> getAllLekEntity() {
        List<LekEntity> allMedicine = lekRepository.findAll();
        return allMedicine;
    }

    public List<Lek> getAllLek() {
        List<Lek> listaLek = new ArrayList<>();
        for (LekEntity lek : lekRepository.findAll()) {
            listaLek.add(new Lek(lek.getNazwa(), lek.getProducent(), lek.getIlosc()));
        }
        return listaLek;
    }

    public List<Lek> getAllLekByName(String nazwa) {
        List<Lek> listaLek = new ArrayList<>();
        for (LekEntity lek : lekRepository.findByNazwa(nazwa)) {
            listaLek.add(new Lek(lek.getNazwa(), lek.getProducent(), lek.getIlosc()));
        }
        return listaLek;
    }

    public List<Lek> getAllLekByProducent(String producent) {
        List<Lek> listaLek = new ArrayList<>();
        for (LekEntity lek : lekRepository.findByProducent(producent)) {
            listaLek.add(new Lek(lek.getNazwa(), lek.getProducent(), lek.getIlosc()));
        }
        return listaLek;
    }

    public List<LekEntity> findAllMed(){
        List<LekEntity> rs =  lekRepository.findAll();
        return rs;
    }
    public Optional<LekEntity> findByIdEntity(Long idP){
        Optional<LekEntity> res = lekRepository.findById(idP);
        return res;
    }

    public String findMedByNazwa(String nazwa){
        List<LekEntity> r = lekRepository.findByNazwa(nazwa);
        return r.toString();
    }
    public String findMedByProducent(String producent){
        List<LekEntity> rr = lekRepository.findByProducent(producent);
        return rr.toString();
    }
}

