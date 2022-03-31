package io.github.renanmiler.petslovers.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 5)
    private Integer codPessoa;
    @Column(nullable = false, length = 150)
    @NotEmpty
    private String nome;
    @Column(nullable = false)
    private Character sexo;
    @Column(nullable = false, length = 11)
    @NotNull
    private String cpf;

    //ENDEREÇO
    @Column(nullable = false, length = 8)
    private String cep;
    @Column(nullable = true, length = 75)
    private String rua;
    @Column(nullable = true, length = 5)
    private String numero;
    @Column(nullable = true, length = 40)
    private String cidade;
    @Column(nullable = true)
    private Integer codEstado;
    @Column(nullable = true)
    private Integer codPais;

    //USUARIO
/*
    @OneToOne
    @JoinColumn(name = "cod_image")
    @NotFound(action = NotFoundAction.IGNORE)
    private Image cod_image;
*/
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String senha;

}
