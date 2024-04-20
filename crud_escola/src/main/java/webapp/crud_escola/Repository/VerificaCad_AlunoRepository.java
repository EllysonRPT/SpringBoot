package webapp.crud_escola.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import webapp.crud_escola.Model.Aluno;
import webapp.crud_escola.Model.VerificaCadAluno;

public interface VerificaCad_AlunoRepository extends CrudRepository<VerificaCadAluno,String>{

        void save(AlunoRepository ar);
        // VerificaCadAluno findByNome(String nome); 
        // VerificaCadAluno findByCpf(String cpf); 
}
