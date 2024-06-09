package br.com.ellyson.apirest_senai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ambiente {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel reponsavel;


}
