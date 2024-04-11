package webapp.crud_escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

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
    @GetMapping("/cadastroAluno")
    public ModelAndView CadAlunoIndex() {
        ModelAndView mv = new ModelAndView("/cadastroAluno");
        return mv;
    }
    @GetMapping("/cadastroProfessor")
    public ModelAndView CadProfIndex() {
        ModelAndView mv = new ModelAndView("cadastroProfessor");
        return mv;
    }
    @GetMapping("/login")
    public ModelAndView loginIndex() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    // @GetMapping("/interna")
    // public ModelAndView internaIndex() {
    //     ModelAndView mv = new ModelAndView("interna");
    //     return mv;
    // }

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
