package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsiz.iid6.gr2.patientservice.dto.Badanie;
import pl.wsiz.iid6.gr2.patientservice.dto.Recepta;
import pl.wsiz.iid6.gr2.patientservice.service.BadanieService;

import java.util.List;

@Controller
@RequestMapping(value= "/badanieWeb")
public class BadanieControllerWeb {
    @Autowired
    private BadanieService badanieService;

    @GetMapping(path="/badaniaAll")
    public String listBadania(final ModelMap model) throws Exception {
        List<Badanie> allBadania= badanieService.findAll();
        model.addAttribute("badania", allBadania);
        return  "badaniaAll";
    }
}
