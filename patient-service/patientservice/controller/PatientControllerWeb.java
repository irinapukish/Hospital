package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
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
        List<Pacjent> allPatient = patientService.findAll();
        model.addAttribute("patients", allPatient);
        return  "pacjentAll";
    }

    @GetMapping(path = "/pacjentByFName")
    public String getAllFName(final ModelMap model, @RequestParam String imie) {
        List<Pacjent> allPatients = patientService.getAllByFirstName(imie);
        model.addAttribute("patients", allPatients);
        return "pacjentAll";
    }

    @GetMapping(path = "/pacjentByLName")
    public String getAllLName(final ModelMap model, @RequestParam String nazwisko) {
        List<Pacjent> allPatients = patientService.getAllByLastName(nazwisko);
        model.addAttribute("patients", allPatients);
        return "pacjentAll";
    }

    @GetMapping(path = "/pacjentByPesel")
    public String getAllPesel(final ModelMap model, @RequestParam String pesel) {
        List<Pacjent> allPatients = patientService.getAllByPesel(pesel);
        model.addAttribute("patients", allPatients);
        return "pacjentAll";
    }

}
