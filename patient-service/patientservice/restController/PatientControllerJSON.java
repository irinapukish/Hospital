package pl.wsiz.iid6.gr2.patientservice.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientControllerJSON {
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/{idP}", produces = "application/json")
    public Pacjent index(@PathVariable Long idP){
        Pacjent pacjent = patientService.findById(idP);
        return pacjent;
    }
    @GetMapping(value = "imie/{imie}", produces = "application/json")
    public List<Pacjent> fname(@PathVariable String imie) {
        List<Pacjent> pacjents = patientService.getAllByFirstName(imie);
        return pacjents;
    }

    @GetMapping(value = "nazwisko/{nazwisko}", produces = "application/json")
    public List<Pacjent> lname(@PathVariable String nazwisko) {
        List<Pacjent> pacjents = patientService.getAllByLastName(nazwisko);
        return pacjents;
    }

    @GetMapping(path="/all", produces = "application/json")
    public List<Pacjent> allPacjent(){
        return patientService.findAll();
    }
}
