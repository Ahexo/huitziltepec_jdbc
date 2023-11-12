/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ahexo
 */
@RestController
@RequestMapping("/postgresApp")
public class ClienteControlador {
    
   @Resource
   ClienteServicio clienteServ;
   
   /**
    * Obtiene todos los clientes registrados en la base de datos.
    * @return Lista de clientes.
    */
   @GetMapping(value = "/clienteList")
   public List<Cliente> getCliente(){
       return clienteServ.findAll();
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
