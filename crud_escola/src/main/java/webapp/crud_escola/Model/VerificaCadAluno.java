package webapp.crud_escola.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class VerificaCadAluno {
    @Id
    private String cpf;
    private String senha;
  

    // Construtor, getters e setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
