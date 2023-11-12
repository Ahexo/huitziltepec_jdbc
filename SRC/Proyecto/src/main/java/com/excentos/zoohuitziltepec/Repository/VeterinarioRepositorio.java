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

import com.excentos.zoohuitziltepec.Model.Veterinario;
import java.util.List;

/**
 *
 * @author ahexo
 */
public interface VeterinarioRepositorio {

    /**
     * Obtiene todos los veterinarios registrados en la base de datos.
     * @return Lista de veterinarios.
     */
    List<Veterinario> findAll();

    /**
     * Inserta un nuevo veterinario en la base de datos.
     * @param veterinario Veterinario a insertar.
     */
    void insertVeterinario(Veterinario veterinario);

    /**
     * Emite una actualización de un veterinario en la base de datos.
     * @param veterinario Veterinario a actualizar.
     */
    void updateVeterinario(Veterinario veterinario);

    /**
     * Ejecuta una operación de actualización de un veterinario accediendo al JDBC.
     * @param veterinario Veterinario a actualizar.
     */
    void executeUpdateVeterinario(Veterinario veterinario);

    /**
     * Borra un veterinario de la base de datos.
     * @param veterinario Veterinario a borrar.
     */
    public void deleteVeterinario(Veterinario veterinario); 
}
