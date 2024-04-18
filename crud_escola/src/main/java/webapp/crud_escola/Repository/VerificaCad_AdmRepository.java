package webapp.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.crud_escola.Model.VerificaCadAdm;

public interface VerificaCad_AdmRepository extends CrudRepository<VerificaCadAdm,String>{
    VerificaCadAdm findByCpf(String cpf); 
    VerificaCadAdm findByNome(String nome); 

}
