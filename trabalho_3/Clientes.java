package com.trabalho_3;

public class Clientes {
    
    private static Integer codigo = 1; 
    private String telefone;
    private String nome;
    private Endereco endereco;
    private Integer codigoCliente; 
    
    public Clientes() {
        this.codigoCliente = codigo++;
        this.nome = "";
        this.telefone = "";
        this.endereco = new Endereco();
    }
    
    public Clientes(String nome, String telefone, Endereco endereco) {
        this.codigoCliente = codigo++; 
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public Integer getCodigo() {
        return codigoCliente; 
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
