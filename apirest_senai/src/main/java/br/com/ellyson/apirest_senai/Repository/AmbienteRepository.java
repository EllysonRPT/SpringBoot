package br.com.ellyson.apirest_senai.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ellyson.apirest_senai.Model.Ambiente;

public interface AmbienteRepository extends CrudRepository<Ambiente,Long> {
    
}
