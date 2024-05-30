package br.com.ellyson.apirest_senai.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ellyson.apirest_senai.Model.Responsavel;
import br.com.ellyson.apirest_senai.Repository.ResponsavelRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * ResponsavelController
 */
@RestController
@Controller
@RequestMapping("/responsavel")

public class ResponsavelController {
    @Autowired
    ResponsavelRepository repository;


@GetMapping()
public List<Responsavel> getResponsavel() {
    return  (List<Responsavel>) repository.findAll();
}
@PostMapping()
public Responsavel postResponsavel(@RequestBody Responsavel responsavel) {

 return repository.save(responsavel);    
} 
@GetMapping("/{id}")
public Optional<Responsavel> getResponsavelById(@PathVariable Long id) {
    return repository.findById(id);
}
@PutMapping("/{id}")
public Responsavel putResponsavel(@PathVariable Long id, @RequestBody Responsavel responsavel) {
    //TODO: process PUT request
    Optional<Responsavel> busca = repository.findById(id);
    if (!busca.isEmpty()) {
        responsavel.setId(id);
        return repository.save(responsavel);
    }else{
        return null;

    }
}
@DeleteMapping("/{id}")
public void deleteResponsavel(@PathVariable Long id){
    Optional<Responsavel> busca = repository.findById(id);
    if (!busca.isEmpty()) {
      repository.deleteById(id);
    }}
 

    
}