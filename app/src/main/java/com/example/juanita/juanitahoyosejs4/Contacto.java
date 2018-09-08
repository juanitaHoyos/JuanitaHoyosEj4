package com.example.juanita.juanitahoyosejs4;

public class Contacto {

    private String genero;
    private String nombre;
    private String numero;

    public Contacto(String nombre,String numero,String genero){

        this.nombre=nombre;
        this.numero=numero;
        this.genero=genero;

    }


    public String getGenero() {
        return genero;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNumero() {
        return numero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
