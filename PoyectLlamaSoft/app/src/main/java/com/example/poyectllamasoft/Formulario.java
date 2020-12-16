package com.example.poyectllamasoft;

public class Formulario {

    private int Id;
    private String Nombre;
    private int Mes;
    private int Ano;

    public Formulario(int id, String nombre, int mes, int ano) {
        Id = id;
        Nombre = nombre;
        Mes = mes;
        Ano = ano;
    }

    public Formulario(String nombre, int mes, int ano) {
        Nombre = nombre;
        Mes = mes;
        Ano = ano;
    }

    public Formulario(int anInt, String string, String cursorString, String s) {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int mes) {
        Mes = mes;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        Ano = ano;
    }
}
