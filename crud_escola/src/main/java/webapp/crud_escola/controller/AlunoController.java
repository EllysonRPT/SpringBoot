package webapp.crud_escola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Aluno;
import webapp.crud_escola.Model.VerificaCadAluno;
import webapp.crud_escola.Repository.AlunoRepository;
import webapp.crud_escola.Repository.VerificaCad_AlunoRepository;

@Controller
public class AlunoController {

    // private Aluno pr;

    @Autowired
    private VerificaCad_AlunoRepository vcalur;

    @Autowired
    private AlunoRepository ar;

    @PostMapping("cad-Aluno")
    public ModelAndView postCadProf(Aluno aluno, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/login-aluno");

        // Verifica se já existe um aluno com o CPF fornecido

        boolean existeCpf = ar.existsById(aluno.getCpf());
        boolean verificaCpf = vcalur.existsById(aluno.getCpf());

        if (verificaCpf && !existeCpf) {
            if (!aluno.getSenha().equals(aluno.getConfirmarSenha())) {
                // Se o CPF não existir, salva o novo aluno
                ar.save(aluno);
                mv.addObject("msg", "Cadastro com sucesso");
            } else {
                mv.addObject("msg", "SENHAS NÃO COINCIDEM");
                mv.addObject("cor", "vermelho");
                mv.setViewName("redirect:/cad-aluno");
            }
        } else {
            // Se o CPF já existir, trata o erro de alguma maneira
            mv.addObject("msg", "CPF NÃO AUTORIZADO");
            mv.addObject("cor", "vermelho");
            mv.setViewName("redirect:/cad-aluno");
        }
        return mv;
    }
}

// // Verifica se as senhas coincidem
// if (!aluno.getSenha().equals(aluno.getConfirmarSenha())) {
// mv.addObject("msg", "As senhas não coincidem.");
// return mv;
// }else{
// mv.addObject("msg", "Preencha todos os campos.");
// mv.addObject("cor", "vermelho");
// mv.setViewName("redirect:/cadastroAluno");
// }

// // Verifica se já existe um aluno com o CPF fornecido
