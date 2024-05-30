package br.com.ellyson.apirest_senai.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ellyson.apirest_senai.Model.AtivoPatrimonial;
import br.com.ellyson.apirest_senai.Model.Responsavel;

public interface AtivoPatrimonialRepository extends CrudRepository<AtivoPatrimonial,Long>{
    
}
