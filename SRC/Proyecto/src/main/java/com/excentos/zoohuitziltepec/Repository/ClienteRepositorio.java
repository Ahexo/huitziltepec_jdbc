/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.excentos.zoohuitziltepec.Repository;

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.util.List;

/**
 * Interfaz que contiene los métodos para el manejo de la tabla Cliente en la base de datos.
 * @author ahexo
 */
public interface ClienteRepositorio {

    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de clientes.
     */
    List<Cliente> findAll();

    /**
     * Inserta un nuevo cliente en la base de datos.
     * @param cliente Cliente a insertar.
     */
    void insertCliente(Cliente cliente);

    /**
     * Emite una actualización de un cliente en la base de datos.
     * @param cliente Cliente a actualizar.
     */
    void updateCliente(Cliente cliente);

    /**
     * Ejecuta una operación de actualización de un cliente accediendo al JDBC.
     * @param cliente Cliente a actualizar.
     */
    void executeUpdateCliente(Cliente cliente);

    /**
     * Borra un cliente de la base de datos.
     * @param cliente Cliente a borrar.
     */
    public void deleteCliente(Cliente cliente); 
}
