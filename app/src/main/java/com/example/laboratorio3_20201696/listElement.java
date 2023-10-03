package com.example.laboratorio3_20201696;

import com.example.laboratorio3_20201696.dto.Picture;

public class listElement {
    public Picture picture;
    public String titulo;
    public String first;
    public String last;
    public String genero;
    public String ciudad;
    public String pais;
    public String email;
    public String telefono;

    public listElement(Picture picture, String titulo, String first, String last, String genero, String ciudad, String pais, String email, String telefono) {
        this.picture = picture;
        this.titulo = titulo;
        this.first = first;
        this.last = last;
        this.genero = genero;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
        this.telefono = telefono;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
