package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;

import java.util.List;

@Controller
@RequestMapping(value= "/medicineWeb")
public class MedicineControllerWeb {
    @Autowired
    private LekService lekService;
    @RequestMapping(path = "/lekiById")
    public String getMedicine(final ModelMap model, @RequestParam Long idP){
        Lek newLek = lekService.findById(idP);
        model.addAttribute("nazwa", newLek.getNazwa());
        model.addAttribute("producent", newLek.getProducent());
        model.addAttribute("ilosc", newLek.getIlosc());
        return "lekId";
    }

    @GetMapping(path = "/findAllMedicine")
    public String getLekAll(final ModelMap model) {
        List<Lek> leki = lekService.getAllLek();
        model.addAttribute("leki", leki);
        return "lekiLista";
    }
    @RequestMapping (path = "/lekiAll")
    public String listLeki(final ModelMap model) throws Exception {
        List<LekEntity> allLeki = lekService.findAllMed();
        model.addAttribute("leki", allLeki);
        return "lekiAll";
    }
    @GetMapping(path = "/findAllMedicineByName")
    public String getAllName(final ModelMap model, @RequestParam String name) {
        List<Lek> leki = lekService.getAllLekByName(name);
        model.addAttribute("leki", leki);
        return "lekiLista";
    }
    @GetMapping(path = "/findAllMedicineByProducent")
    public String getAllProducent(final ModelMap model, @RequestParam String producent) {
        List<Lek> leki = lekService.getAllLekByProducent(producent);
        model.addAttribute("leki", leki);
        return "lekiLista";
    }


}
