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

package com.excentos.zoohuitziltepec.Controller;

import com.excentos.zoohuitziltepec.Service.ClienteServicio;
import com.excentos.zoohuitziltepec.Model.Cliente;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controlador provee las direcciones a las cuales hacer las distintas peticiones
 * CRUD sobre la tabla de Clientes de la base de datos del Zoológico de Hutiziltepec, las 
 * cuales son resueltas por el servicio correspondiente a la misma tabla.
 * @author ahexo
 */
@RestController
@RequestMapping("/postgresApp")
public class ClienteControlador {
    
   @Resource
   ClienteServicio clienteServ;
   
   /**
    * Regresa todos los clientes registrados en la base de datos.
    * @return Lista de clientes.
    */
   @GetMapping(value = "/clienteList")
   public List<Cliente> getClientes(){
       return clienteServ.findAll();
   }
   
    /**
    * Obtiene un cliente de la base de datos dado su ID.
    * @param idCliente Número de identificación del cliente.
    * @return Lista con el cliente. Si está vacía, es porque no hay clientes con ese ID.
    */
   @GetMapping(value = "/cliente")
   public List<Cliente> getCliente(@RequestParam int idCliente){
       return clienteServ.selectCliente(idCliente);
   }
   
   /**
    * Inserta un nuevo cliente en la base de datos.
    * @param cliente Cliente a insertar.
    */
   @PostMapping(value = "/createCliente")
   public void createCliente(@RequestBody Cliente cliente){
       clienteServ.insertCliente(cliente);
   }
   
    /**
     * Emite una actualización de un cliente en la base de datos.
     * @param cliente Cliente a actualizar.
     */
   @PutMapping(value = "/updateCliente")
   public void updateCliente(@RequestBody Cliente cliente){
       clienteServ.updateCliente(cliente);
   }
   
    /**
     * Ejecuta una operación de actualización de un cliente en la base de datos.
     * @param cliente Cliente a actualizar.
     */
   @PutMapping(value = "/executeUpdateCliente")
   public void executeUpdateCliente(@RequestBody Cliente cliente){
       clienteServ.executeUpdateCliente(cliente);
   }
   
    /**
     * Borra un cliente de la base de datos.
     * @param cliente Cliente a borrar.
     */
   @DeleteMapping(value = "/deleteClienteById")
   public void borrarCliente(@RequestBody Cliente cliente){
       clienteServ.deleteCliente(cliente);
   }
   
}
