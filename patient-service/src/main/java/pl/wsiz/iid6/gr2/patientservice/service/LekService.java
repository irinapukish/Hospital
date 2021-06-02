package pl.wsiz.iid6.gr2.patientservice.service;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import org.springframework.stereotype.Service;

@Service
public class LekService {
    // przykładowo w repozytorium będzie
    private Lek[] leki = {new Lek("Ibuprom", "Sanofi"),
            new Lek("szczepionka", "Astra"),
            new Lek("Paracetamol", "Polfa")};
    public Lek findLek(String nazwa) {
        for (Lek lek : leki) {
            if (lek.getNazwa().equals(nazwa)) {
                return lek;
            }
        }
        return new Lek(nazwa);
    }
    public String getAllLek(){
        String allMedicine = "Lek - Producent; ";
        for(Lek lek: leki){
            allMedicine = allMedicine+lek.getNazwa()+" - "+lek.getProducent()+"; ";
        }
        return allMedicine;
    }

}

