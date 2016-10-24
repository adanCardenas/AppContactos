package com.cardenas.adan.appcontactos.model;

import java.util.Date;

/**
 * Created by adan_ on 23/10/2016.
 */

public class Contacto {
    private String nombreCompleto;
    private String fechaNacimeinto;
    private Date fechaNacimientoDate;
    private String telefono;
    private String email;
    private String descripción;

    public Contacto() {
    }

    public Contacto(String nombreCompleto, String email) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public Contacto(String nombreCompleto, String fechaNacimeinto, String telefono, String email, String descripción) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimeinto = fechaNacimeinto;
        this.telefono = telefono;
        this.email = email;
        this.descripción = descripción;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getFechaNacimeinto() {
        return fechaNacimeinto;
    }

    public void setFechaNacimeinto(String fechaNacimeinto) {
        this.fechaNacimeinto = fechaNacimeinto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Date getFechaNacimientoDate() {
        return fechaNacimientoDate;
    }

    public void setFechaNacimientoDate(Date fechaNacimientoDate) {
        this.fechaNacimientoDate = fechaNacimientoDate;
    }
}
