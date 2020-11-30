package com.example.proyectollamasoft;

public class Formulario {
    private String Nombre;
    private String Mes;
    private String Ano;

    public Formulario(String nombre, String mes, String ano) {
        Nombre = nombre;
        Mes = mes;
        Ano = ano;
    }

    public Formulario() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMes() {
        return Mes;
    }

    public void setMes(String mes) {
        Mes = mes;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }
}
