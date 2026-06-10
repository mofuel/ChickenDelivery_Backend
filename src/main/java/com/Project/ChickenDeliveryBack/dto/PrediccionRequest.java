package com.Project.ChickenDeliveryBack.dto;

public class PrediccionRequest {

    private int dia_semana_num;
    private int mes;
    private int dia;
    private int es_feriado;

    public int getDia_semana_num() {
        return dia_semana_num;
    }

    public void setDia_semana_num(int dia_semana_num) {
        this.dia_semana_num = dia_semana_num;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getEs_feriado() {
        return es_feriado;
    }

    public void setEs_feriado(int es_feriado) {
        this.es_feriado = es_feriado;
    }
}