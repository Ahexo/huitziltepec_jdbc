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

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 * Este RowMapper transforma el resultado de una consulta SQL en la tabla de
 * clientes en un objeto cliente, operable por el resto del programa.
 * @author ahexo
 */
public class ClienteRowMapper implements RowMapper<Cliente> {
    
    /**
     * Construye un objeto Cliente mapeando los datos de una entrada/tupla con los
     * datos de un cliente.
     * @param rs Conjunto de valores de la tupla obtenida de la consulta SQL.
     * @param rowNum Número de la entrada de la tupla.
     * @return Objeto Cliente con los valores obtenidos de la tupla.
     * @throws SQLException.
     */
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idCliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setaPaterno(rs.getString("aPaterno"));
        cliente.setaMaterno(rs.getString("aMaterno"));
        cliente.setNacimiento(rs.getDate("nacimiento"));
        cliente.setGenero(rs.getString("genero").charAt(0));
        
        return cliente;
    }
    
}
