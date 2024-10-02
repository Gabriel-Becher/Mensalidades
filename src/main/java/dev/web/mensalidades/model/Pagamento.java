package dev.web.mensalidades.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.OnDelete;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;


@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod_pagamento;
    
    @Column(name = "ano", nullable = false)
    private short ano;

    @Column(name = "mes", nullable = false)
    private short mes;

    @Column(name = "valor", nullable = false)
    private double valor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cod_jogador")
    Jogador jogador;

    public Pagamento() {

    }

    public Pagamento(short ano, short mes, double valor) {
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
    }


    public long getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(long cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Jogador getJogador(){
        return jogador;
    }

    public void setJogador(Jogador jogador){
        this.jogador = jogador;
    }

    @Override
    public String toString() {
        return "Pagamento [ano=" + ano + ", cod_pagamento=" + cod_pagamento + ", mes=" + mes + ", valor=" + valor + "]";
    }

}
