package com.clima.bean;

public class CadClienteBean {

    int id_estado;
    String nome_estado;
    String mesorregiao;
    String uf;
    int id_cidade;
    String nome_cidade;
    int id_endereco;
    String rua;
    String numero;
    int id_cliente;
    String nomeCliente;
    String sobrenomeCliente;
    String situacao;
    int id_loginUsuario;

    public CadClienteBean() {
    }

    public CadClienteBean(int id_estado, String nome_estado, String mesorregiao, String uf, int id_cidade, String nome_cidade, int id_endereco, String rua, String numero, int id_cliente, String nomeCliente, String sobrenomeCliente, String situacao, int id_loginUsuario) {
        this.id_estado = id_estado;
        this.nome_estado = nome_estado;
        this.mesorregiao = mesorregiao;
        this.uf = uf;
        this.id_cidade = id_cidade;
        this.nome_cidade = nome_cidade;
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.numero = numero;
        this.id_cliente = id_cliente;
        this.nomeCliente = nomeCliente;
        this.sobrenomeCliente = sobrenomeCliente;
        this.situacao = situacao;
        this.id_loginUsuario = id_loginUsuario;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    public String getMesorregiao() {
        return mesorregiao;
    }

    public void setMesorregiao(String mesorregiao) {
        this.mesorregiao = mesorregiao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSobrenomeCliente() {
        return sobrenomeCliente;
    }

    public void setSobrenomeCliente(String sobrenomeCliente) {
        this.sobrenomeCliente = sobrenomeCliente;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId_loginUsuario() {
        return id_loginUsuario;
    }

    public void setId_loginUsuario(int id_loginUsuario) {
        this.id_loginUsuario = id_loginUsuario;
    }
 
}
