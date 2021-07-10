package pl.wsiz.iid6.gr2.patientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.util.List;

//http://localhost:5000/patient/all
@Controller
@RequestMapping(value= "/patient")
public class PatientController {
@Autowired
private PatientService patientService;
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
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

        return (patientService.findById(idP)).toString();
    }

    @GetMapping(path = "/lname")
    @ResponseBody
    public String patientLName(@RequestParam String name) {

        return (patientService.findByLNameEntity(name)).toString();
    }
    @GetMapping(path = "/fname")
    @ResponseBody
    public String patientFName(@RequestParam String name) {

        return (patientService.findByFNameEntity(name)).toString();
    }
    @GetMapping(path = "/pesel")
    @ResponseBody
    public String patientPesels(@RequestParam String pesel){
        return (patientService.findByPeselEntity(pesel)).toString();
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public String patientAll(){
        String s ="";
                for(PatientEntity x: patientService.findAllEntity()){
                    s=s+"<p>"+ x.toString()+"<p>";
                }
                return s;
    }
}
