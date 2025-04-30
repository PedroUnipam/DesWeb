package com.example.projeto.model;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="pesssoas")
public class Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.INDETITY)
    private long id;

    private String nome;
    private Integer idade;

    public Pessoa(){

    }

    public Pessoa(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }
}