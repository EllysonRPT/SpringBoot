package webapp.crud_escola.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import webapp.crud_escola.CrudEscolaApplication;
import webapp.crud_escola.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno,String> {
    Optional<Aluno> findById(String cpf);
    // Aluno findBySenha(String senha);
}
// 