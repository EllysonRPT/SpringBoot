package webapp.crud_escola.Repository;
import org.springframework.data.repository.CrudRepository;
import webapp.crud_escola.Model.Adm;
import java.util.List;


public interface AdmRepository extends  CrudRepository<Adm,String>{
    Adm findByCpf(String cpf);
    Adm findBySenha(String senha);
}
