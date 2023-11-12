/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.excentos.zoohuitziltepec.Service;

import com.excentos.zoohuitziltepec.Model.Veterinario;
import java.util.List;

/**
 *
 * @author ahexo
 */
public interface VeterinarioServicio {

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
    void deleteVeterinario(Veterinario veterinario); 
}
