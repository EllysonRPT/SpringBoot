package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Aluno;
import webapp.crud_escola.Model.VerificaCadAluno;
import webapp.crud_escola.Repository.AlunoRepository;
import webapp.crud_escola.Repository.VerificaCad_AlunoRepository;

public class AlunoController {
    @Autowired
    private Aluno pr;
    @Autowired
    private VerificaCad_AlunoRepository vcar;
    @Autowired
    private AlunoRepository ar;




    @PostMapping("cadastroAluno")
    public ModelAndView postCadProf(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-aluno");
        // TODO: process POST request
      boolean verificaCpf = vcar.existsById(pr.getCpf()) ;
    //   VerificaCadAdm verificaNome = vcar.findByNome(adm.getNome()) ;
    // String cad = "";
        if (verificaCpf ) {
            vcar.save(ar);
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
