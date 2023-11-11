/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Mapper;

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 *
 * @author ahexo
 */
public class ClienteRowMapper implements RowMapper<Cliente> {
    
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
