package webapp.hello_world.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        // Define uma mensagem padrão ao abrir a página
        mv.addObject("msg", "Olá, seja bem-vindo(a)!");

        return mv;
    }

    @PostMapping("/")
    public ModelAndView buscarIndex(@RequestParam("nome") String nome,
                                    @RequestParam("email") String email,
                                    @RequestParam("telefone") String telefone) {
        ModelAndView mv = new ModelAndView("index");

        // Define uma mensagem de resultado da busca
        mv.addObject("msg", "Resultado da Busca!");

        // Adiciona os atributos recebidos do formulário
        mv.addObject("nome", nome);
        mv.addObject("email", email);
        mv.addObject("telefone", telefone);

        return mv;
    }
}
