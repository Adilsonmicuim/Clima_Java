
package com.clima.arduino;

import java.sql.Date;

public class TempArduinoBEAN {
    int id_TempArduino;
    double tempMax;
    double tempMin;
    double tempAtual;
    Date dataHoraRegistro;

    public TempArduinoBEAN() {
    }

    public TempArduinoBEAN(int id_TempArduino, double tempMax, double tempMin, double tempAtual, Date dataHoraRegistro) {
        this.id_TempArduino = id_TempArduino;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.tempAtual = tempAtual;
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public int getId_TempArduino() {
        return id_TempArduino;
    }

    public void setId_TempArduino(int id_TempArduino) {
        this.id_TempArduino = id_TempArduino;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempAtual() {
        return tempAtual;
    }

    public void setTempAtual(double tempAtual) {
        this.tempAtual = tempAtual;
    }

    public Date getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(Date dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }
    
}
