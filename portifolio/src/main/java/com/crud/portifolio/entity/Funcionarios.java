package com.crud.portifolio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionarios")
public class Funcionarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionarios")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "idade")
    private int idade;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "cargo")
    private String cargo;

}
