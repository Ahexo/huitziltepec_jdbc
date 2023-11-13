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

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.util.List;

/**
 * Es necesario vincular el controlador con el repositorio para obtener o hacer
 * efectivas las consultas, para esto hay que implementar los métodos aqui 
 * especificados en una nueva clase que comunique a ambos objetos, la cual 
 * llamaremos "servicio para clientes".
 * @author ahexo
 */
public interface ClienteServicio {

    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de clientes.
     */
    List<Cliente> findAll();
    
    /**
     * Obtiene un cliente en particular en base a su ID
     * @return Cliente buscado. Si no existe, se entrega un objeto Cliente vacío.
     * @param idCliente Número identificador del cliente.
     */
    Cliente selectCliente(int idCliente);

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
    void deleteCliente(Cliente cliente);
}
