package webapp.crud_escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
  
@Controller
public class IndexController {
//
    // método
    @GetMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView homeIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("/cad-aluno")
    public ModelAndView CadAlunoIndex() {
        ModelAndView mv = new ModelAndView("cad-aluno");
        return mv;
    }
    @GetMapping("/cadastroProf")
    public ModelAndView CadProfIndex() {
        ModelAndView mv = new ModelAndView("interna/cadastroProf");
        return mv;
    }

    @GetMapping("/internaProf")
    public ModelAndView InternaProfIndex() {
        ModelAndView mv = new ModelAndView("interna/internaProf");
        return mv;
    }

    @GetMapping("/internaAluno")
    public ModelAndView InternaAlunoIndex() {
        ModelAndView mv = new ModelAndView("interna/internaAluno");
        return mv;
    }

    @GetMapping("/login-aluno")
    public ModelAndView loginAlunoIndex() {
        ModelAndView mv = new ModelAndView("login-aluno");
        return mv;
    }
    @GetMapping("/login-prof")
    public ModelAndView loginProfIndex() {
        ModelAndView mv = new ModelAndView("login-prof");
        return mv;
    }
    

    @RequestMapping(value = "/login-adm", method = RequestMethod.GET)
    public ModelAndView abrirLoginAdm() {
        ModelAndView mv = new ModelAndView("adm/login-adm");
        return mv;
    }
    @RequestMapping(value = "/cad-adm", method = RequestMethod.GET)
    public ModelAndView abrirCadAdm() {
        ModelAndView mv = new ModelAndView("adm/cad-adm");
        return mv;
    }

}
