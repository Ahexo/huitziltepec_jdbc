/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author ahexo
 */
@Repository
public class VeterinarioRepositorioImp implements VeterinarioRepositorio {
    
    NamedParameterJdbcTemplate template;
    
    public VeterinarioRepositorioImp(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    
    @Override
    public List<Veterinario> findAll() {
        return template.query("SELECT * FROM Veterinario", new VeterinarioRowMapper());
    }

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
