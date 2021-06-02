package pl.wsiz.iid6.gr2.patientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {
    @Autowired
    private LekService lekService;

    @GetMapping(path = "/findMedicine")
    @ResponseBody
    public Lek getMedine(@RequestParam String name){

        return lekService.findLek(name);
    }

    @GetMapping(path ="/allMedicine")
    @ResponseBody
    public String getAllLeki(){
        //wstrzykujemy LekService
        return lekService.getAllLek();
    }

}
