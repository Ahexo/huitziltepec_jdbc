/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Repository;

import com.excentos.zoohuitziltepec.Mapper.ClienteRowMapper;
import com.excentos.zoohuitziltepec.Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahexo
 */
@Repository
public class ClienteRepositorioImp implements ClienteRepositorio {
    
    NamedParameterJdbcTemplate template;
    
    public ClienteRepositorioImp(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    
    @Override
    public List<Cliente> findAll() {
        return template.query("SELECT * FROM Cliente", new ClienteRowMapper());
    }

    @Override
    public void insertCliente(Cliente cliente) {
        final String sql = "INSERT INTO Cliente(idCliente, nombre, aPaterno, aMaterno, nacimiento, genero) " +
                "values (:idCliente, :nombre, :aPaterno, :aMaterno, :nacimiento, :genero)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("idCliente", cliente.getIdCliente())
                .addValue("nombre", cliente.getNombre())
                .addValue("aPaterno", cliente.getaPaterno())
                .addValue("aMaterno", cliente.getaMaterno())
                .addValue("nacimiento", cliente.getNacimiento())
                .addValue("genero", cliente.getGenero());
        template.update(sql, param, holder);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        final String sql = "UPDATE Cliente SET idCliente=:idCliente, nombre=:nombre, aPaterno=:aPaterno, nacimiento=:nacimiento, genero=:genero WHERE idCliente=:idCliente";
        
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("idCliente", cliente.getIdCliente())
                .addValue("nombre", cliente.getNombre())
                .addValue("aPaterno", cliente.getaPaterno())
                .addValue("aMaterno", cliente.getaMaterno())
                .addValue("nacimiento", cliente.getNacimiento())
                .addValue("genero", cliente.getGenero());
        template.update(sql, param, holder);
    }

    @Override
    public void executeUpdateCliente(Cliente cliente) {
        final String sql = "UPDATE Cliente SET idCliente=:idCliente, nombre=:nombre, aPaterno=:aPaterno, nacimiento=:nacimiento, genero=:genero WHERE idCliente=:idCliente";

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("idCliente", cliente.getIdCliente());
        map.put("nombre", cliente.getNombre());
        map.put("aPaterno", cliente.getaPaterno());
        map.put("aMaterno", cliente.getaMaterno());
        map.put("nacimiento", cliente.getNacimiento());
        map.put("genero", cliente.getGenero());
        
        template.execute(sql,map,new PreparedStatementCallback<Object>(){
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException{
                    return ps.executeUpdate();
                }           
        });
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        final String sql = "DELETE FROM Cliente WHERE idCliente=:idCliente";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("idCliente",cliente.getIdCliente());
            template.execute(sql,map,new PreparedStatementCallback<Object>(){
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException{
                    return ps.executeUpdate();
                }       
        });
    } 
}
