package pl.wsiz.iid6.gr2.patientservice.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineControllerJSON {
    @Autowired
    private LekService lekService;

    @GetMapping(value = "/{idP}", produces = "application/json")
    public Lek index(@PathVariable Long idP) {
        Lek product = lekService.findById(idP);
        return product;
    }

    @GetMapping(path="name/{name}", produces = "application/json")
    public List<Lek> allLekByName(@PathVariable String name){

        return lekService.getAllLekByName(name);
    }

    @GetMapping(path="producent/{producent}", produces = "application/json")
    public List<Lek> allLekByProducent(@PathVariable String producent){
        return lekService.getAllLekByProducent(producent);
    }

    @GetMapping(path="/all", produces = "application/json")
    public List<Lek> allLek(){
        return lekService.getAllLek();
    }
}

