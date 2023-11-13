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

package com.excentos.zoohuitziltepec.Service;

import com.excentos.zoohuitziltepec.Repository.VeterinarioRepositorio;
import com.excentos.zoohuitziltepec.Model.Veterinario;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Este servicio pasa las peticiones hechas al servidor por medio del controlador
 * para consultar o manipular la tabla de veterinarios de la base de datos del 
 * Zoológico de Huitziltepec.
 * @author ahexo
 */
@Service
public class VeterinarioServicioImp implements VeterinarioServicio {
    
    @Resource
    VeterinarioRepositorio veterinarioRepo;
    
    /**
     * Obtiene todos los veterinarios registrados en la base de datos.
     * @return Lista de veterinarios.
     */
    @Override
    public List<Veterinario> findAll() {
        return veterinarioRepo.findAll();
    }

    /**
     * Obtiene un veterinario en particular en base a su ID
     * @return Veterinario buscado contenido en una lista.
     * @param idVeterinario Número identificador del veterinario.
     */
    @Override
    public Veterinario selectVeterinario(String RFC) {
        return veterinarioRepo.selectVeterinario(RFC);
    }
    
    /**
     * Inserta un nuevo veterinario en la base de datos.
     * @param veterinario Veterinario a insertar.
     */
    @Override
    public void insertVeterinario(Veterinario veterinario) {
        veterinarioRepo.insertVeterinario(veterinario);
    }

    /**
     * Emite una actualización de un veterinario en la base de datos.
     * @param veterinario Veterinario a actualizar.
     */
    @Override
    public void updateVeterinario(Veterinario veterinario) {
        veterinarioRepo.updateVeterinario(veterinario);
    }

    /**
     * Ejecuta una operación de actualización de un veterinario accediendo al JDBC.
     * @param veterinario Veterinario a actualizar.
     */
    @Override
    public void executeUpdateVeterinario(Veterinario veterinario) {
        veterinarioRepo.executeUpdateVeterinario(veterinario);
    }

    /**
     * Borra un veterinario de la base de datos.
     * @param veterinario Veterinario a borrar.
     */
    @Override
    public void deleteVeterinario(Veterinario veterinario) {
        veterinarioRepo.deleteVeterinario(veterinario);
    }
    
}
