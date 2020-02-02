package com.clima.bean;

import java.sql.Date;

public class EvapotranspiracaoBean {

    int id_evapotranspiracao;
    String unidade_medida;
    Date data_evapotranspiracao;
    Double qtidade_evapo;
    String data_hora_registro;
    int id_cliente;
    int id_modeloequipamentoevapo;
    String modelo_descricao;
    //private CadClienteBean cadClienteBean;

    //Construtor vazio     
    public EvapotranspiracaoBean() {
    }

    //Construtor preenchido    
    public EvapotranspiracaoBean(String unidade_medida, Date data_evapotranspiracao, Double qtidade_evapo, String data_hora_registro, int id_cliente, int id_modeloequipamentoevapo, String modelo_descricao) {
        this.unidade_medida = unidade_medida;
        this.data_evapotranspiracao = data_evapotranspiracao;
        this.qtidade_evapo = qtidade_evapo;
        this.data_hora_registro = data_hora_registro;
        this.id_cliente = id_cliente;
        this.id_modeloequipamentoevapo = id_modeloequipamentoevapo;
        this.modelo_descricao = modelo_descricao;
    }

    public int getId_evapotranspiracao() {
        return id_evapotranspiracao;
    }

    public void setId_evapotranspiracao(int id_evapotranspiracao) {
        this.id_evapotranspiracao = id_evapotranspiracao;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Date getData_evapotranspiracao() {
        return data_evapotranspiracao;
    }

    public void setData_evapotranspiracao(Date data_evapotranspiracao) {
        this.data_evapotranspiracao = data_evapotranspiracao;
    }

    public Double getQtidade_evapo() {
        return qtidade_evapo;
    }

    public void setQtidade_evapo(Double qtidade_evapo) {
        this.qtidade_evapo = qtidade_evapo;
    }

    public String getData_hora_registro() {
        return data_hora_registro;
    }

    public void setData_hora_registro(String data_hora_registro) {
        this.data_hora_registro = data_hora_registro;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_modeloequipamentoevapo() {
        return id_modeloequipamentoevapo;
    }

    public void setId_modeloequipamentoevapo(int id_modeloequipamentoevapo) {
        this.id_modeloequipamentoevapo = id_modeloequipamentoevapo;
    }

    public String getModelo_descricao() {
        return modelo_descricao;
    }

    public void setModelo_descricao(String modelo_descricao) {
        this.modelo_descricao = modelo_descricao;
    }

}
