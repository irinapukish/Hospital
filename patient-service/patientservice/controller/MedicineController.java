package pl.wsiz.iid6.gr2.patientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;

import java.util.List;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {
    @Autowired
    private LekService lekService;

    @GetMapping(path = "/lekiById")
    @ResponseBody
    public String getMedineById(@RequestParam Long idP){

        return (lekService.findById(idP)).toString();
    }
    @GetMapping(path = "/lekiByNazwa")
    @ResponseBody
    public String getMedineByNazwa(@RequestParam String nazwa){
        return lekService.findMedByNazwa(nazwa);
    }

    @GetMapping(path = "/lekiByProducent")
    @ResponseBody
    public String getMedineByProducent(@RequestParam String producent){
        return lekService.findMedByProducent(producent);
    }

    @GetMapping(path="/lekiAll")
    @ResponseBody
    public String MedAll(){
        String s="";
        for (LekEntity x : lekService.findAllMed()) {
            s=s+"<p>"+x.toString()+"</p>";
        } return s;
    }

    @GetMapping(path="/findAllMedicine")
    @ResponseBody
    public List<Lek> getAllLek(@RequestParam Long idP){
        return lekService.getAllLek();
    }


}
