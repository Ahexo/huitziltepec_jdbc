/*
 * Fundamentos de Bases de Datos
 * Grupo 7803, Semestre 2024-1
 * 12 de noviembre de 2023
 * Práctica 8: JDBC
 * Equipo: Los Excentos
 * Alejandro Axel Rodríguez Sánchez (315247697)
 * Brenda Ayala Flores (319051287)
 * Jorge Daniel Velasco García (319238545)
 * José Fernando Cervantes Duarte (422100827)
 * Roberto Samuel Sánchez Rosas (318355159)
 */

package com.excentos.zoohuitziltepec.Model;

import java.util.Date;

/**
 * Este es un modelo de una tupla de la tabla Cliente en la base de datos del Zoológico de Huitziltepec.
 * Esta captura el ID del cliente, su nombre, apellidos paterno y materno, su fecha de nacimiento y la inicial de su género.
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

    /**
     * Constructor de la clase Cliente.
     * @param idCliente ID del cliente.
     * @param nombre Nombre(s) del cliente.
     * @param aPaterno Apellido paterno del cliente.
     * @param aMaterno Apellido materno del cliente.
     * @param nacimiento Fecha de nacimiento del cliente.
     * @param genero Género del cliente, representado por una inicial mayúscula (M,F,X).
     */
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
