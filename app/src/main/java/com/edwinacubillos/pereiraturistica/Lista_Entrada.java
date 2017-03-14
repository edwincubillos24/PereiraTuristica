package com.edwinacubillos.pereiraturistica;

/**
 * Created by Edwin on 14/03/2017.
 */

public class Lista_Entrada {

    private int idImagen;
    private String nombre, descrip, direc;

    public Lista_Entrada(int idImagen, String nombre, String descrip, String direc) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.direc = direc;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }
}
