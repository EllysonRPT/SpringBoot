package br.com.ellyson.apirest_senai.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ellyson.apirest_senai.Model.Responsavel;
@RestController
@Controller
@RequestMapping("/Ambiente")
public class AmbienteController {
    
//     @GetMapping()
// public List<Responsavel> getResponsavel() {
//     return  (List<Responsavel>) repository.findAll();
// }
// @PostMapping()
// public Responsavel postResponsavel(@RequestBody Responsavel responsavel) {

//  return repository.save(responsavel);    
// }

}
