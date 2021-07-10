package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Badanie;
import pl.wsiz.iid6.gr2.patientservice.entity.BadanieEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.BadanieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BadanieService {
    @Autowired
    private BadanieRepository badanieRepository;

    public List<Badanie> findAll(){
        List<Badanie> psc = new ArrayList<>();
        for(BadanieEntity x : badanieRepository.findAll()){
            psc.add(new Badanie(x.getTypBadania(), x.getOpis(),x.getCzyWymagaSkierowania(), x.getCenaBadania()));
        }
        return psc;
    }
}
