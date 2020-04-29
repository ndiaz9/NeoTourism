package com.neotourism;

import java.util.ArrayList;

public class Dato {

    private String nombre;

    private int distancia;

    private ArrayList<String> tags;

    private int foto;

    public Dato(String nombre, int distancia, ArrayList<String> tags, int foto) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.tags = tags;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
