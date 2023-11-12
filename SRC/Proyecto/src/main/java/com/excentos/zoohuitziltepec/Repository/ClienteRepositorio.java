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

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.util.List;

/**
 * El repositorio se comunica directamente con la base de datos por medio de JDBC
 * haciendo uso de consultas predefinidas, las cuales se deben implementar siguiendo
 * las firmas y descipciones especificadas en esta interfaz.
 * @author ahexo
 */
public interface ClienteRepositorio {

    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de clientes.
     */
    List<Cliente> findAll();
    
    /**
     * Obtener un cliente de la base de datos en base a su ID
     * @param idCliente Número de indentificación del cliente. 
     * @return Cliente buscado contenido en una lista.
     */
    List<Cliente> selectCliente(int idCliente);

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
     * Hace efectiva una operación de actualización de un cliente.
     * @param cliente Cliente a actualizar.
     */
    void executeUpdateCliente(Cliente cliente);

    /**
     * Borra un cliente de la base de datos.
     * @param cliente Cliente a borrar.
     */
    public void deleteCliente(Cliente cliente); 
}
