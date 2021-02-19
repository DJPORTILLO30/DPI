package com.danilo.portillo;

public class Usuario {
    private String Nombre;
    public int DPI;
    private int Edad;

    public String getNombre() {
        return Nombre;
    }



    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;

    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;

    }

    public void setEdad(int Edad) {
        this.Edad = Edad;

    }

    public int getEdad() {
        return Edad;
    }


}
