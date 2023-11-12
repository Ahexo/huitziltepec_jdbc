/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Mapper;

import com.excentos.zoohuitziltepec.Model.Veterinario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author ahexo
 */
public class VeterinarioRowMapper implements RowMapper<Veterinario> {
    
    @Override
    public Veterinario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Veterinario veterinario = new Veterinario();
        //cliente.setIdCliente(rs.getInt("idCliente"));
        veterinario.setRFCVeterinario(rs.getString("RFCVeterinario"));
        veterinario.setNombre(rs.getString("nombre"));
        veterinario.setaPaterno(rs.getString("aPaterno"));
        veterinario.setaMaterno(rs.getString("aMaterno"));
        veterinario.setNacimiento(rs.getDate("nacimiento"));
        veterinario.setGenero(rs.getString("genero").charAt(0));
        veterinario.setCalle(rs.getString("calle"));
        veterinario.setNumExterior(rs.getInt("numExterior"));
        veterinario.setNumInterior(rs.getInt("numInterior"));
        veterinario.setColonia(rs.getString("colonia"));
        veterinario.setEstado(rs.getString("estado"));
        veterinario.setInicioContrato(rs.getDate("inicioContrato"));
        veterinario.setFinContrato(rs.getDate("finContrato"));
        veterinario.setEspecialidad(rs.getString("especialidad"));
        veterinario.setSalario(rs.getFloat("salario"));
        
        return veterinario;
    }
    
}
