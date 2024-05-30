package br.com.ellyson.apirest_senai.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Responsavel implements Serializable {
//atributos
@Id
private  Long id;
private  String nome;


}
