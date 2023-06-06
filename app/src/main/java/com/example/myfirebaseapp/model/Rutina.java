package com.example.myfirebaseapp.model;

public class Rutina {

    private String rid;
    private String Texto;

    public Rutina() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    @Override
    public String toString() {
        return Texto;
    }
}
