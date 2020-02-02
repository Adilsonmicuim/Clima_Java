package com.clima.bean;

import java.sql.Date;

public class TemperaturaBean {

    int id_temperatura;
    String unidade_medida;
    Date data_temperatura;
    Double temp_maxima;
    Double temp_minima;
    int id_cliente;
    String data_hora_registro;
    //private CadClienteBean cadClienteBean;

    //Construtor vazio     
    public TemperaturaBean() {
    }

    //Construtor preenchido     
    public TemperaturaBean(String unidade_medida, Date data_temperatura, Double temp_maxima, Double temp_minima, int id_cliente, String data_hora_registro) {
        this.unidade_medida = unidade_medida;
        this.data_temperatura = data_temperatura;
        this.temp_maxima = temp_maxima;
        this.temp_minima = temp_minima;
        this.id_cliente = id_cliente;
        this.data_hora_registro = data_hora_registro;
    }

    
    
    public int getId_temperatura() {
        return id_temperatura;
    }

    public void setId_temperatura(int id_temperatura) {
        this.id_temperatura = id_temperatura;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Date getData_temperatura() {
        return data_temperatura;
    }

    public void setData_temperatura(Date data_temperatura) {
        this.data_temperatura = data_temperatura;
    }

    public Double getTemp_maxima() {
        return temp_maxima;
    }

    public void setTemp_maxima(Double temp_maxima) {
        this.temp_maxima = temp_maxima;
    }

    public Double getTemp_minima() {
        return temp_minima;
    }

    public void setTemp_minima(Double temp_minima) {
        this.temp_minima = temp_minima;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getData_hora_registro() {
        return data_hora_registro;
    }

    public void setData_hora_registro(String data_hora_registro) {
        this.data_hora_registro = data_hora_registro;
    }
}
