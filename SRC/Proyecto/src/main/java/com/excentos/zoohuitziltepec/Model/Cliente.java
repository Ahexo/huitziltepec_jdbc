/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Model;

import java.util.Date;

/**
 *
 * @author ahexo
 */
public class Cliente {
    private Integer idCliente;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private Date nacimiento;
    private char genero;
    
    
    public Cliente() {
        
    }

    public Cliente(Integer idCliente, String nombre, String aPaterno, String aMaterno, Date nacimiento, char genero) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nacimiento = nacimiento;
        this.genero = genero;
    }

    /**
     * @return ID del cliente.
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente nuevo ID del cliente.
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return Nombre(s) del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo(s) nombre(s) del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El apellido paterno del cliente.
     */
    public String getaPaterno() {
        return aPaterno;
    }

    /**
     * @param aPaterno Nuevo apellido paterno del cliente.
     */
    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    /**
     * @return El apellido materno del cliente.
     */
    public String getaMaterno() {
        return aMaterno;
    }

    /**
     * @param aMaterno Nuevo apellido materno del cliente.
     */
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    /**
     * @return Fecha de nacimiento del cliente.
     */
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento Nueva fecha de nacimiento del cliente.
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return Inicial del género del cliente.
     */
    public char getGenero() {
        return genero;
    }

    /**
     * @param genero Nuevo género del veterinario, representado por una inicial mayúscula (M,F,X).
     */
    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", nacimiento=" + nacimiento + ", genero=" + genero + '}';
    }
    
}
