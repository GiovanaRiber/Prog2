package com.trabalho_final;

import org.bson.codecs.pojo.annotations.BsonProperty;
import java.time.LocalDate;

public class Producao {

    @BsonProperty(value = "nome")
    private String nome;

    @BsonProperty(value = "data")
    private LocalDate data;

    @BsonProperty(value = "litros")
    private double litros; // Alterado para double

    // Construtor vazio (necessário para o MongoDB ou frameworks que utilizam reflexão)
    public Producao() {
    }

    // Construtor completo
    public Producao(String nome, LocalDate data, double litros) {
        this.nome = nome;
        this.data = data;
        this.litros = litros;
    }

    // Getters e Setters
    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Sobrescrita do toString() para facilitar debug e exibição
    @Override
    public String toString() {
        return "Producao{" +
                "nome='" + nome + '\'' +
                ", data=" + data +
                ", litros=" + litros +
                '}';
    }
}
