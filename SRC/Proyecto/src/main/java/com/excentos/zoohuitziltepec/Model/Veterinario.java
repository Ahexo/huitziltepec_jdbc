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
public class Veterinario {
    private String RFCVeterinario;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private Date nacimiento;
    private char genero;
    private String calle;
    private Integer numExterior;
    private Integer numInterior;
    private String colonia;
    private String estado;
    private Date inicioContrato;
    private Date finContrato;
    private String especialidad;
    private Float salario;
    
    public Veterinario() {
        
    }

    public Veterinario(String RFCVeterinario, String nombre, String aPaterno, String aMaterno, Date nacimiento, char genero, String calle, Integer numExterior, Integer numInterior, String colonia, String estado, Date inicioContrato, Date finContrato, String especialidad, Float salario) {
        this.RFCVeterinario = RFCVeterinario;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nacimiento = nacimiento;
        this.genero = genero;
        this.calle = calle;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.colonia = colonia;
        this.estado = estado;
        this.inicioContrato = inicioContrato;
        this.finContrato = finContrato;
        this.especialidad = especialidad;
        this.salario = salario;
    }
    
    

    /**
     * @return El RFC del veterinario.
     */
    public String getRFCVeterinario() {
        return RFCVeterinario;
    }

    /**
     * @param RFCVeterinario Nuevo RFC del veterinario.
     */
    public void setRFCVeterinario(String RFCVeterinario) {
        this.RFCVeterinario = RFCVeterinario;
    }

    /**
     * @return Nombre(s) del veterinario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre Nuevo(s) nombre(s) del veterinario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El apellido paterno del veterinario.
     */
    public String getaPaterno() {
        return aPaterno;
    }

    /**
     * @param aPaterno Nuevo apellido paterno del veterinario.
     */
    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    /**
     * @return El apellido materno del veterinario.
     */
    public String getaMaterno() {
        return aMaterno;
    }

    /**
     * @param aMaterno Nuevo apellido materno del veterinario.
     */
    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    /**
     * @return Fecha de nacimiento del veterinario.
     */
    public Date getNacimiento() {
        return nacimiento;
    }

    /**
     * @param nacimiento Nueva fecha de nacimiento del veterinario.
     */
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    /**
     * @return Inicial del género del veterinario.
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

    /**
     * @return Calle del domicilio del veterinario.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle Calle del nuevo domicilio del veterinario.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return Número exterior del domicilio del veterinario.
     */
    public Integer getNumExterior() {
        return numExterior;
    }

    /**
     * @param numExterior Número exterior del nuevo domicilio del veterinario.
     */
    public void setNumExterior(Integer numExterior) {
        this.numExterior = numExterior;
    }

    /**
     * @return Número interior del domicilio del veterinario.
     */
    public Integer getNumInterior() {
        return numInterior;
    }

    /**
     * @param numInterior Número interior del nuevo domicilio del veterinario.
     */
    public void setNumInterior(Integer numInterior) {
        this.numInterior = numInterior;
    }

    /**
     * @return Colonia donde vive el veterinario.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia Nueva colonia donde reside el veterinario.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return Estado donde reside el veterinario.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado Nuevo estado de residencia del veterinario.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return Fecha de inicio del contrato del veterinario.
     */
    public Date getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato Nueva fecha de inicio del contrato del veterinario.
     */
    public void setInicioContrato(Date inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return Fecha de fin del contrato del veterinario.
     */
    public Date getFinContrato() {
        return finContrato;
    }

    /**
     * @param finContrato ueva fecha de fin del contrato del veterinario.
     */
    public void setFinContrato(Date finContrato) {
        this.finContrato = finContrato;
    }

    /**
     * @return Especialidad del veterinario.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad Nueva especialidad del veterinario.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return Salario actual del veterinario.
     */
    public Float getSalario() {
        return salario;
    }

    /**
     * @param salario Nuevo salario del veterinario.
     */
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "RFCVeterinario=" + RFCVeterinario + ", nombre=" + nombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + ", nacimiento=" + nacimiento + ", genero=" + genero + ", calle=" + calle + ", numExterior=" + numExterior + ", numInterior=" + numInterior + ", colonia=" + colonia + ", estado=" + estado + ", inicioContrato=" + inicioContrato + ", finContrato=" + finContrato + ", especialidad=" + especialidad + ", salario=" + salario + '}';
    }
 
    
}
