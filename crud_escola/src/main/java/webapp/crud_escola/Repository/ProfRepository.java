package webapp.crud_escola.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import webapp.crud_escola.Model.Aluno;
import webapp.crud_escola.Model.Professor;

public interface ProfRepository extends CrudRepository <Professor,String> {
    Optional<Professor> findById(String cpf);
}
