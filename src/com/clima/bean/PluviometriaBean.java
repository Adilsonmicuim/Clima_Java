
package com.clima.bean;

public class PluviometriaBean {
  private int id_pluviometria;
  private String unidade_medida;
  private String data_pluviometria;
  private String qtidade_chuva;
  private String id_cliente;
  private int id_ocorrencia; 
  private boolean granizo;
  private boolean faltou_energia;

    public PluviometriaBean(int id_pluviometria, String unidade_medida, String data_pluviometria, String qtidade_chuva, String id_cliente, int id_ocorrencia, boolean granizo, boolean faltou_energia) {
        this.id_pluviometria = id_pluviometria;
        this.unidade_medida = unidade_medida;
        this.data_pluviometria = data_pluviometria;
        this.qtidade_chuva = qtidade_chuva;
        this.id_cliente = id_cliente;
        this.id_ocorrencia = id_ocorrencia;
        this.granizo = granizo;
        this.faltou_energia = faltou_energia;
    }

    public PluviometriaBean() {
    }

    public int getId_pluviometria() {
        return id_pluviometria;
    }

    public void setId_pluviometria(int id_pluviometria) {
        this.id_pluviometria = id_pluviometria;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getData_pluviometria() {
        return data_pluviometria;
    }

    public void setData_pluviometria(String data_pluviometria) {
        this.data_pluviometria = data_pluviometria;
    }

    public String getQtidade_chuva() {
        return qtidade_chuva;
    }

    public void setQtidade_chuva(String qtidade_chuva) {
        this.qtidade_chuva = qtidade_chuva;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_ocorrencia() {
        return id_ocorrencia;
    }

    public void setId_ocorrencia(int id_ocorrencia) {
        this.id_ocorrencia = id_ocorrencia;
    }

    public boolean isGranizo() {
        return granizo;
    }

    public void setGranizo(boolean granizo) {
        this.granizo = granizo;
    }

    public boolean isFaltou_energia() {
        return faltou_energia;
    }

    public void setFaltou_energia(boolean faltou_energia) {
        this.faltou_energia = faltou_energia;
    }
  
}
