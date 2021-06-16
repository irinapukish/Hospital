package pl.wsiz.iid6.gr2.patientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;

import java.util.List;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {
    @Autowired
    private LekService lekService;

    @GetMapping(path = "/findMedId")
    @ResponseBody
    public String getMedineById(@RequestParam Long idP){

        return (lekService.findById(idP)).toString();
    }
    @GetMapping(path = "/findMedNazwa")
    @ResponseBody
    public String getMedineByNazwa(@RequestParam String nazwa){
        return lekService.findByNazwa(nazwa);
    }

    @GetMapping(path="/all")
    @ResponseBody
    public String MedAll(){
        String s="";
        for (LekEntity x : lekService.findAll()) {
            s=s+"<p>"+x.toString()+"</p>";
        } return s;
    }

    @RequestMapping(path = "/lek")
    public String getMedicine(final ModelMap model, @RequestParam Long idP){
        Lek newLek = lekService.findById(idP);
        model.addAttribute("nazwa", newLek.getNazwa());
        model.addAttribute("producent", newLek.getProducent());
        model.addAttribute("ilosc", newLek.getIlosc());
        return "lekInfo.html";
    }
    @RequestMapping (path = "/lekiall")
    public String listLeki(final ModelMap model) throws Exception {
        List<LekEntity> allLeki = lekService.findAll();
        model.addAttribute("leki", allLeki);
        return "lekiAll.html";
    }





}
