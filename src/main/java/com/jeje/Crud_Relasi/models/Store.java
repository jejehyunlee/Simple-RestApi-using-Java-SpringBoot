package com.jeje.Crud_Relasi.models;


import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name = "tb_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "nama")
    private String name;
    @Column(name = "alamat")
    private String address;

}
