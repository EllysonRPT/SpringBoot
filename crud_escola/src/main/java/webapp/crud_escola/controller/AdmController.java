package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.crud_escola.Model.Adm;
import webapp.crud_escola.Repository.AdmRepository;
import webapp.crud_escola.Repository.VerificaCad_AdmRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AdmController
 */
@Controller
public class AdmController {
    @Autowired
   private AdmRepository ar;
   private VerificaCad_AdmRepository vcar;


    @PostMapping("/cad-adm")
    public String postCadAdm(Adm adm) {
        // TODO: process POST request
        String cpfVerificar = vcar.findByCpf(adm.getCpf()).getCpf();
        if (cpfVerificar.equals(adm.getCpf())) {
            ar.save(adm);
            
        }
        return "adm/longin-adm";

    }

}