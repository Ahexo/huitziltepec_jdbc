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

import com.excentos.zoohuitziltepec.Repository.ClienteRepositorio;
import com.excentos.zoohuitziltepec.Model.Cliente;
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
public class ClienteServicioImp implements ClienteServicio {
    
    @Resource
    ClienteRepositorio clienteRepo;
    
    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de clientes.
     */
    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll(); 
    }

    /**
     * Obtiene un cliente en particular en base a su ID
     * @return Cliente buscado contenido en una lista.
     * @param idCliente Número identificador del cliente.
     */
    @Override
    public Cliente selectCliente(int idCliente) {
        return clienteRepo.selectCliente(idCliente);
    }
    
    /**
     * Inserta un nuevo cliente en la base de datos.
     * @param cliente Cliente a insertar.
     */
    @Override
    public void insertCliente(Cliente cliente) {
        clienteRepo.insertCliente(cliente);
    }

    /**
     * Emite una actualización de un cliente en la base de datos.
     * @param cliente Cliente a actualizar.
     */
    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepo.updateCliente(cliente);
    }

    /**
     * Ejecuta una operación de actualización de un cliente accediendo al JDBC.
     * @param cliente Cliente a actualizar.
     */
    @Override
    public void executeUpdateCliente(Cliente cliente) {
        clienteRepo.executeUpdateCliente(cliente);
    }

    /**
     * Borra un cliente de la base de datos.
     * @param cliente Cliente a borrar.
     */
    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepo.deleteCliente(cliente);
    }
    
}
