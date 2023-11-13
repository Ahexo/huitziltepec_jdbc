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

import com.excentos.zoohuitziltepec.Mapper.VeterinarioRowMapper;
import com.excentos.zoohuitziltepec.Model.Veterinario;
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
 * de JDBC en la tabla de veterinarios de la base de datos del Zoológico de Huitziltepec.
 * @author ahexo
 */
@Repository
public class VeterinarioRepositorioImp implements VeterinarioRepositorio {
    
    NamedParameterJdbcTemplate template;
    
    public VeterinarioRepositorioImp(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    
    /**
     * Obtiene todos los veterinarios registrados en la base de datos.
     * @return Lista de veterinarios.
     */
    @Override
    public List<Veterinario> findAll() {
        return template.query("SELECT * FROM Veterinario", new VeterinarioRowMapper());
    }
    
    /**
     * Obtener un veterinario de la base de datos en base a su RFC
     * @param RFC RFC del veterinario.
     * @return Veterinario buscado o un objeto vacio si es que no existe uno con el RFC especificado.
     */
    @Override
    public Veterinario selectVeterinario(String RFC) {
        String sql = String.format("SELECT * FROM Veterinario WHERE RFCVeterinario= \'%s\'", RFC);
        
        Veterinario resultado;
        
        try {
            resultado = template.query(sql, new VeterinarioRowMapper()).get(0);
        }
        catch (IndexOutOfBoundsException exc) {
            return new Veterinario();
        }
        
        return resultado;
    }

    /**
     * Inserta un nuevo veterinario en la base de datos.
     * @param cliente Veterinario a insertar.
     */
    @Override
    public void insertVeterinario(Veterinario veterinario) {
        final String sql = "INSERT INTO Veterinario(RFCVeterinario, nombre, aPaterno, aMaterno, nacimiento, genero, calle, numExterior, numInterior, colonia, estado, inicioContrato, finContrato, especialidad, salario) " +
                "values (:RFCVeterinario, :nombre, :aPaterno, :aMaterno, :nacimiento, :genero, :calle, :numExterior, :numInterior, :colonia, :estado, :inicioContrato, :finContrato, :especialidad, salario)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("RFCVeterinario", veterinario.getRFCVeterinario())
                .addValue("nombre", veterinario.getNombre())
                .addValue("aPaterno", veterinario.getaPaterno())
                .addValue("aMaterno", veterinario.getaMaterno())
                .addValue("nacimiento", veterinario.getNacimiento())
                .addValue("genero", veterinario.getGenero())
                .addValue("calle", veterinario.getCalle())
                .addValue("numExterior", veterinario.getNumExterior())
                .addValue("numInterior", veterinario.getNumInterior())
                .addValue("colonia", veterinario.getColonia())
                .addValue("estado", veterinario.getEstado())
                .addValue("inicioContrato", veterinario.getInicioContrato())
                .addValue("finContrato", veterinario.getFinContrato())
                .addValue("especialidad", veterinario.getEspecialidad())
                .addValue("salario", veterinario.getSalario());
        template.update(sql, param, holder);
    }

    /**
     * Emite una actualización de un veterinario en la base de datos.
     * @param cliente Veterinario a actualizar.
     */
    @Override
    public void updateVeterinario(Veterinario veterinario) {
        final String sql = "UPDATE Cliente SET RFCVeterinario=:RFCVeterinario, nombre=:nombre, aPaterno=:aPaterno, aMaterno=:aMaterno, nacimiento=:nacimiento, genero=:genero, calle=:calle, numExterior=:numExterior, numInterior=:numInterior, colonia=:colonia, estado=:estado, inicioContrato=:inicioContrato, finContrato=:finContrato, especialidad=:especialidad, salario=:salario";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("RFCVeterinario", veterinario.getRFCVeterinario())
                .addValue("nombre", veterinario.getNombre())
                .addValue("aPaterno", veterinario.getaPaterno())
                .addValue("aMaterno", veterinario.getaMaterno())
                .addValue("nacimiento", veterinario.getNacimiento())
                .addValue("genero", veterinario.getGenero())
                .addValue("calle", veterinario.getCalle())
                .addValue("numExterior", veterinario.getNumExterior())
                .addValue("numInterior", veterinario.getNumInterior())
                .addValue("colonia", veterinario.getColonia())
                .addValue("estado", veterinario.getEstado())
                .addValue("inicioContrato", veterinario.getInicioContrato())
                .addValue("finContrato", veterinario.getFinContrato())
                .addValue("especialidad", veterinario.getEspecialidad())
                .addValue("salario", veterinario.getSalario());
        template.update(sql, param, holder);
    }

    /**
     * Hace efectiva una operación de actualización de un veterinario.
     * @param cliente Veterinario a actualizar.
     */
    @Override
    public void executeUpdateVeterinario(Veterinario veterinario) {
        final String sql = "UPDATE Cliente SET idCliente=:idCliente, nombre=:nombre, aPaterno=:aPaterno, nacimiento=:nacimiento, genero=:genero WHERE idCliente=:idCliente";

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("RFCVeterinario", veterinario.getRFCVeterinario());
        map.put("nombre", veterinario.getNombre());
        map.put("aPaterno", veterinario.getaPaterno());
        map.put("aMaterno", veterinario.getaMaterno());
        map.put("nacimiento", veterinario.getNacimiento());
        map.put("genero", veterinario.getGenero());
        map.put("calle", veterinario.getCalle());
        map.put("numExterior", veterinario.getNumExterior());
        map.put("numInterior", veterinario.getNumInterior());
        map.put("colonia", veterinario.getColonia());
        map.put("estado", veterinario.getEstado());
        map.put("inicioContrato", veterinario.getInicioContrato());
        map.put("finContrato", veterinario.getFinContrato());
        map.put("especialidad", veterinario.getEspecialidad());
        map.put("salario", veterinario.getSalario());
        
        
        template.execute(sql,map,new PreparedStatementCallback<Object>(){
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException{
                    return ps.executeUpdate();
                }           
        });
    }

    
    /**
     * Borra un veterinario de la base de datos.
     * @param cliente Veterinario a borrar.
     */
    @Override
    public void deleteVeterinario(Veterinario veterinario) {
        final String sql = "DELETE FROM Veterinario WHERE RFCVeterinario=:RFCVeterinario";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("RFCVeterinario",veterinario.getRFCVeterinario());
        template.execute(sql,map,new PreparedStatementCallback<Object>(){
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException{
                return ps.executeUpdate();
            }       
        });
    }
    
}
