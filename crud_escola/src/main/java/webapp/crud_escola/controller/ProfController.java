package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Professor;
import webapp.crud_escola.Model.VerificaCadProf;
import webapp.crud_escola.Repository.ProfRepository;

@Controller
public class ProfController {
    @Autowired
    private Professor pr;
    @Autowired
    private VerificaCadProf vcar;
 
    @Autowired
    private ProfRepository pfr;
 








    
    @PostMapping("cadastroProf")
    public ModelAndView postCadProf( RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-Prof");
        // TODO: process POST request
      boolean verificaCpf = vcar.existsById(pr.getCpf()) ;
    //   VerificaCadAdm verificaNome = vcar.findByNome(adm.getNome()) ;
    // String cad = "";
        if (verificaCpf ) {
            vcar.save(pfr);
            mv.addObject("msg", "Cadastro com sucesso");
        }else{
            String mensagem = "SEM PERMISSÃO";
            System.out.println(mensagem);
            mv.setViewName("redirect:/cad-adm");
            mv.addObject("msg", "ERROR LOG");
            mv.addObject("cor", "vermelho");
        }
        return mv;
    }

}
