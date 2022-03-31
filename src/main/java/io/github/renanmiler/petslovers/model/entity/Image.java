package io.github.renanmiler.petslovers.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_image;

    @Lob
    @Column(length = Integer.MAX_VALUE, nullable = false)
    private byte[] image;
}
