package pl.wsiz.iid6.gr2.patientservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Pacjent findById(Long id) {
        Optional<PatientEntity> res = patientRepository.findById(id);
        if (res.isPresent()) {
            PatientEntity pat = res.get();
            return new Pacjent(pat.getFirstName(),pat.getLastName(),pat.getPesel(), pat.getNrUbezpieczenia());
        }
        return new Pacjent("None", "None", "None", 0);
    }
    public Optional<PatientEntity> findByIdEntity(Long idP){
        Optional<PatientEntity> res = patientRepository.findById(idP);
        return res;
    }

    public String findByFNameEntity(String name){

        List<PatientEntity> rs = patientRepository.findAllByFirstName(name);
        return rs.toString();
    }
    public String findByLNameEntity(String name){

        List<PatientEntity> rs = patientRepository.findAllByLastName(name);
        return rs.toString();
    }
    public List<PatientEntity> findAllEntity(){
        List<PatientEntity> rs =  patientRepository.findAll();
        return rs;
    }
    public List<PatientEntity> findByPeselEntity(String pesel){
        List<PatientEntity> rs = patientRepository.findAllByPesel(pesel);
        return rs;
    }

    public List<Pacjent> findAll(){
        List<Pacjent> psc = new ArrayList<>();
        for(PatientEntity x : findAllEntity()){
            psc.add(new Pacjent(x.getFirstName(), x.getLastName(), x.getPesel(), x.getNrUbezpieczenia()));
        }
        return psc;
    }
    public List<Pacjent> getAllByFirstName(String imie){
        List<Pacjent> psc = new ArrayList<>();
        for(PatientEntity x : patientRepository.findAllByFirstName(imie)){
            psc.add(new Pacjent(x.getFirstName(), x.getLastName(), x.getPesel(), x.getNrUbezpieczenia()));
        }
        return psc;
    }
    public List<Pacjent> getAllByLastName(String nazwisko){
        List<Pacjent> psc = new ArrayList<>();
        for(PatientEntity x : patientRepository.findAllByLastName(nazwisko)){
            psc.add(new Pacjent(x.getFirstName(), x.getLastName(), x.getPesel(), x.getNrUbezpieczenia()));
        }
        return psc;
    }
    public List<Pacjent> getAllByPesel(String pesel){
        List<Pacjent> psc = new ArrayList<>();
        for(PatientEntity x : patientRepository.findAllByPesel(pesel)){
            psc.add(new Pacjent(x.getFirstName(), x.getLastName(), x.getPesel(), x.getNrUbezpieczenia()));
        }
        return psc;
    }
}
