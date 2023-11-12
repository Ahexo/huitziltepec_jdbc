/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Controller;

import com.excentos.zoohuitziltepec.Service.VeterinarioServicio;
import com.excentos.zoohuitziltepec.Model.Veterinario;
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
public class VeterinarioControlador {
    
   @Resource
   VeterinarioServicio veterinarioServ;
   
   @GetMapping(value= "/veterinarioList")
   public List<Veterinario> getVeterinario(){
       return veterinarioServ.findAll();
   }
   
   @PostMapping(value= "/createVeterinario")
   public void createVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.insertVeterinario(veterinario);
   }
   
   @PutMapping(value = "/updateVeterinario")
   public void updateVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.updateVeterinario(veterinario);
   }
   
   @PutMapping(value = "/executeUpdateVeterinario")
   public void executeUpdateVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.executeUpdateVeterinario(veterinario);
   }
   
   @DeleteMapping(value = "/deleteVeterinarioById")
   public void borrarVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.deleteVeterinario(veterinario);
   }
   
}
