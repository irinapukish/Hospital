package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.util.List;

@Controller
@RequestMapping(value= "/patientWeb")
public class PatientControllerWeb {
    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/pacjentId")
    public String pacjentId(final ModelMap model, Long idP){
        model.addAttribute("nr", idP);
        Pacjent patient = patientService.findById(idP);
        model.addAttribute("imie", patient.getImie());
        model.addAttribute("nazwisko", (patient.getNazwisko()));
        model.addAttribute("pesel", (patient.getPesel()));
        model.addAttribute("nrUbezpieczenia",patient.getNrUbezpieczenia());
        return "pacjent";
    }

    @GetMapping(path="/pacjentAll")
    public String listPatient(final ModelMap model) throws Exception {
        List<PatientEntity> allPatient = patientService.findAllEntity();
        model.addAttribute("patients", allPatient);
        return  "pacjentAll";
    }

}
