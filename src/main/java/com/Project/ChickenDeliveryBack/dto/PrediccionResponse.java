package com.Project.ChickenDeliveryBack.dto;

public class PrediccionResponse {

    private int delivery;
    private int recojo;
    private int total;

    public PrediccionResponse() {
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getRecojo() {
        return recojo;
    }

    public void setRecojo(int recojo) {
        this.recojo = recojo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}