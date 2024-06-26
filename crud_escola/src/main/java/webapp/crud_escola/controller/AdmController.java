package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Adm;
import webapp.crud_escola.Model.Professor;
import webapp.crud_escola.Model.VerificaCadAdm;
import webapp.crud_escola.Model.VerificaCadAluno;
import webapp.crud_escola.Model.VerificaCadProf;
import webapp.crud_escola.Repository.AdmRepository;
import webapp.crud_escola.Repository.VerificaCad_AdmRepository;
import webapp.crud_escola.Repository.VerificaCad_AlunoRepository;
import webapp.crud_escola.Repository.VerificaCad_ProfRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * AdmController
 */
@Controller
public class AdmController {


 
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
    @RequestMapping(value = "/cadastroAluno", method = RequestMethod.GET)
    public ModelAndView abrirCadAluno() {
        ModelAndView mv = new ModelAndView("interna/cadastroAluno");
        return mv;
    }


    @Autowired // identifica auto escrita(bin)
    private AdmRepository ar;
    @Autowired
    private VerificaCad_AdmRepository vcar;
    @Autowired
    private VerificaCad_AlunoRepository vcalur;
    @Autowired
     VerificaCad_ProfRepository vcpr;
    
 

    boolean aceesoInternoAdm = false;

    @PostMapping("cad-adm")
    public ModelAndView postCadAdm(Adm adm, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-adm");
        // TODO: process POST request
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        // VerificaCadAdm verificaNome = vcar.findByNome(adm.getNome()) ;
        // String cad = "";
        if (verificaCpf) {
            ar.save(adm);
            mv.addObject("msg", "Cadastro com sucesso");
        } else {
            String mensagem = "ERROR CADASTRO";
            System.out.println(mensagem);
            mv.setViewName("redirect:/cad-adm");
            mv.addObject("msg", "ERROR LOG");
            mv.addObject("cor", "vermelho");
        }
        return mv;
    }

    @PostMapping("acesso-adm")
    public ModelAndView postLoginAdm(@RequestParam String cpf,
            @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");// pagina interna

        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());
        if (acessoCPF && acessoSenha) {
            aceesoInternoAdm = true;
            attributes.addFlashAttribute("msg", "LOGIN REALIZADO");
            attributes.addFlashAttribute("cor", "verde");
            String mensagem = "Login Efetuado";
            System.out.println(mensagem);
        } else {
            String mensagem = " Não Efetuado";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login-adm");
            attributes.addFlashAttribute("msg", "ERRO NO LOGIN");
            attributes.addFlashAttribute("cor", "vermelho");
        }

        return mv;
    }

    @GetMapping("/interna-adm")
    public String aceessoInterno() {
        ModelAndView mv = new ModelAndView();// pagina interna
        String acesso = "";
        if (aceesoInternoAdm) {
            acesso = "interna/interna-adm";
            mv.addObject("msg", "Login efetuado");
            mv.addObject("cor", "verde");
            // mv.setViewName("interna/interna-adm");

        } else {
            acesso = "adm/login-adm";
            mv.addObject("msg", "Login nao efetuado");
            mv.addObject("cor", "vermelho");
        }
        return acesso;
    }

    @PostMapping("logout-adm")
    public ModelAndView LogOutAdm(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-adm");
        attributes.addFlashAttribute("msg", "LOG OUT");
        attributes.addFlashAttribute("cor", "verde");
        aceesoInternoAdm = false;
        return mv;
    }

    @PostMapping("Pre-Cad-Aluno")
    public ModelAndView PreCadProf(VerificaCadAluno aluno, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/cadastroAluno");
        boolean verificaCpf = vcalur.existsById(aluno.getCpf());

        // Verifica se os campos estão vazios
        if ( !aluno.getCpf().isEmpty() && !aluno.getSenha().isEmpty() ) {
            if (!verificaCpf) {
                // Se o CPF não existir, salva o novo aluno
             vcalur.save(aluno);
            mv.addObject("msg", "Cadastro com sucesso");          
             mv.addObject("cor", "verde");
            return mv;
            }
            else {
                // Se o CPF já existir, trata o erro de alguma maneira
                mv.addObject("msg", "CPF já cadastrado");
                mv.addObject("cor", "vermelho");
            }
        }     
        return mv;
    }

    @PostMapping("pre-cad-Prof")
    public ModelAndView PreCadProf(VerificaCadProf Ver_professor, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/cadastroProf");
        
        // Verifica se já existe um professor com o CPF fornecido
        boolean verificaCpf = vcpr.existsById(Ver_professor.getCpf());
    
        if (!verificaCpf) {
            // Se o CPF não existir, salva o novo professor
            vcpr.save(Ver_professor);
            attributes.addFlashAttribute("msg", "CADASTRO REALIZADO");
            attributes.addFlashAttribute("cor", "verde");
            } else {
            // Se o CPF já existir, trata o erro de alguma maneira
            String mensagem = "CPF já cadastrado";
            System.out.println(mensagem);
            mv.setViewName("redirect:/cadastroProf");
            attributes.addFlashAttribute("msg", "CADASTRO ERRO");
            attributes.addFlashAttribute("cor", "vermelho");
        }
        
        return mv;
    }
}
