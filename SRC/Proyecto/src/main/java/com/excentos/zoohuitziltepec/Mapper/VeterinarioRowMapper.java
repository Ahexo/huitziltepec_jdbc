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

package com.excentos.zoohuitziltepec.Mapper;

import com.excentos.zoohuitziltepec.Model.Veterinario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 * Este RowMapper transforma el resultado de una consulta SQL en la tabla de
 * veterinarios en un objeto veterinario, operable por el resto del programa.
 * @author ahexo
 */
public class VeterinarioRowMapper implements RowMapper<Veterinario> {
    
    /**
     * Construye un objeto Veterinario mapeando los datos de una entrada/tupla con los
     * datos de un veterinario.
     * @param rs Conjunto de valores de la tupla obtenida de la consulta SQL.
     * @param rowNum Número de la entrada de la tupla.
     * @return Objeto Veterinario con los valores obtenidos de la tupla.
     * @throws SQLException.
     */
    @Override
    public Veterinario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Veterinario veterinario = new Veterinario();
        //veterinario.setIdVeterinario(rs.getInt("idVeterinario"));
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
