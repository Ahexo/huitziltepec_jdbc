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

package com.excentos.zoohuitziltepec.Repository;

import com.excentos.zoohuitziltepec.Mapper.ClienteRowMapper;
import com.excentos.zoohuitziltepec.Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * Este componente recibe las distintas consultas y operaciones solicitadas desde
 * el controlador y pre-procesadas por el servicio, para realizarlas por medio
 * de JDBC en la tabla de clientes de la base de datos del Zoológico de Huitziltepec.
 * @author ahexo
 */
@Repository
public class ClienteRepositorioImp implements ClienteRepositorio {
    
    NamedParameterJdbcTemplate template;
    
    public ClienteRepositorioImp(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    
    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de clientes.
     */
    @Override
    public List<Cliente> findAll() {
        return template.query("SELECT * FROM Cliente", new ClienteRowMapper());
    }

    /**
     * Obtener un cliente de la base de datos en base a su ID
     * @param idCliente Número de indentificación del cliente. 
     * @return Cliente buscado. Si no se encontró el ID, se regresa un objeto cliente vacío.
     */
    @Override
    public Cliente selectCliente(int idCliente) {
        String sql = "SELECT * FROM Cliente where idCliente=" + idCliente;
        Cliente resultado;
        
        try {
            resultado = template.query(sql, new ClienteRowMapper()).get(0);
        }
        catch (IndexOutOfBoundsException exc) {
            return new Cliente();
        }
        
        return resultado;
    }
    
    /**
     * Inserta un nuevo cliente en la base de datos.
     * @param cliente Cliente a insertar.
     */
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

    /**
     * Emite una actualización de un cliente en la base de datos.
     * @param cliente Cliente a actualizar.
     */
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

    /**
     * Hace efectiva una operación de actualización de un cliente.
     * @param cliente Cliente a actualizar.
     */
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

    /**
     * Borra un cliente de la base de datos.
     * @param cliente Cliente a borrar.
     */
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
