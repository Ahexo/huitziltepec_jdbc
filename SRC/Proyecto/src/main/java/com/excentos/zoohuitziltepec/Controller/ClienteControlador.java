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
   
   @GetMapping(value = "/clienteList")
   public List<Cliente> getCliente(){
       return clienteServ.findAll();
   }
   
   @PostMapping(value = "/createCliente")
   public void createCliente(@RequestBody Cliente cliente){
       clienteServ.insertCliente(cliente);
   }
   
   @PutMapping(value = "/updateCliente")
   public void updateCliente(@RequestBody Cliente cliente){
       clienteServ.updateCliente(cliente);
   }
   
   @PutMapping(value = "/executeUpdateCliente")
   public void executeUpdateCliente(@RequestBody Cliente cliente){
       clienteServ.executeUpdateCliente(cliente);
   }
   
   @DeleteMapping(value = "/deleteClienteById")
   public void borrarCliente(@RequestBody Cliente cliente){
       clienteServ.deleteCliente(cliente);
   }
   
}
