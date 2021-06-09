package pl.wsiz.iid6.gr2.patientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.util.List;

//http://localhost:5000/patient/all
@Controller
@RequestMapping(value= "/patient")
public class PatientController {
@Autowired
private PatientService patientService;
    @GetMapping(path="/name")
    @ResponseBody
    public String name() {
        return "Witamy w naszym systemie";
    }

    @GetMapping(path = "/bye")
    @ResponseBody
    public  String pa(){

        return "Do zobaczenia następnym razem";
    }

    @GetMapping(path = "/age")
    @ResponseBody
    public String age(@RequestParam(required = true) int yearNow, @RequestParam int yearBirth) {
        return Integer.toString(yearNow-yearBirth);
    }

    @GetMapping(path = "/id")
    @ResponseBody
    public String patientId(@RequestParam Long idP) {

        return (patientService.findbyId(idP)).toString();
    }
    @RequestMapping(value = "/pacjent")
    public String pacjent(final ModelMap model, Long idP){
        model.addAttribute("nr", idP);
        Pacjent patient = patientService.findbyId(idP);
        model.addAttribute("imie", patient.getImie());
        model.addAttribute("nazwisko", (patient.getNazwisko()));
        model.addAttribute("pesel", (patient.getPesel()));
        return "pacjent.html";
    }


    @GetMapping(path = "/names")
    @ResponseBody
    public String patientName(@RequestParam String name) {

        return (patientService.findByLastName(name)).toString();
    }



    @GetMapping(path = "/all")
    @ResponseBody
    public String patientAll(){
        String s ="";
                for(PatientEntity x: patientService.findAll()){
                    s=s+"<p>"+ x.toString()+"<p>";
                }
                return s;
    }

    //http://localhost:5000/patient/patientsall
    @GetMapping(path="/patientsall")
    public String listPatients(final ModelMap model) throws Exception {
        List<PatientEntity> allPatient = patientService.findAll();
        model.addAttribute("patients", allPatient);
        return  "pacjentAll.html";
    }

}
