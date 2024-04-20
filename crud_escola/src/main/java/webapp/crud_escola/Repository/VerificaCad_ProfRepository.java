package webapp.crud_escola.Repository;

import org.springframework.data.repository.CrudRepository;
import webapp.crud_escola.Model.VerificaCadAdm;
import webapp.crud_escola.Model.VerificaCadProf;

public interface VerificaCad_ProfRepository extends CrudRepository<VerificaCadProf,String>{
    // VerificaCadProf findByCpf(String cpf); 
    // VerificaCadAdm findByNome(String nome); 

}
