package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Professor;
import webapp.crud_escola.Model.VerificaCadProf;
import webapp.crud_escola.Repository.ProfRepository;

@Controller
public class ProfController {
   
 
    @Autowired
    private ProfRepository pfr;

    boolean aceesoInternoAdm = false;
    
    @GetMapping("/internaProf")
    public ModelAndView InternaProfIndex() {
        ModelAndView mv = new ModelAndView("interna/internaProf");
        return mv;
    }
    
    @PostMapping("cad-Prof")
    public ModelAndView postCadProf(Professor professor, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-Prof");
        
        // Verifica se já existe um professor com o CPF fornecido
        boolean verificaCpf = pfr.existsById(professor.getCpf());
    
        if (!verificaCpf) {
            // Se o CPF não existir, salva o novo professor
            pfr.save(professor);
            mv.addObject("msg", "Cadastro com sucesso");
        } else {
            // Se o CPF já existir, trata o erro de alguma maneira
            String mensagem = "CPF já cadastrado";
            System.out.println(mensagem);
            mv.setViewName("redirect:/alguma-pagina-de-erro");
            mv.addObject("msg", "CPF já cadastrado");
            mv.addObject("cor", "vermelho");
        }
        
        return mv;
    }
}
