package io.github.renanmiler.petslovers.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_pet;

    /*
    @Column(nullable = false)
    private Integer cod_tipo;
    */
    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 30)
    private String regiao;


    @Column(nullable = true, length = 1000)
    private String img;

    /*
    @OneToMany
    @JoinColumn
    private Image id_images;
*/
}

