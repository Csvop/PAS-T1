package com.bcopstein.CtrlCorredorV1.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Corredor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nroCorredor;
    private String cpf;
    private String nome;
    private int dia,mes,ano;
    private String genero;

    public Corredor(String cpf, String nome, int dia,int mes,int ano, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.genero = genero;
    }

    protected Corredor() {}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getDiaDn() {
        return dia;
    }

    public int getMesDn() {
        return mes;
    }
    public int getAnoDn() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

}