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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controlador provee las direcciones a las cuales hacer las distintas peticiones
 * CRUD sobre la tabla de veterinarios de la base de datos del Zoológico de Hutiziltepec, las 
 * cuales son resueltas por el servicio correspondiente a la misma tabla.
 * @author ahexo
 */
@RestController
@RequestMapping("/postgresApp")
public class VeterinarioControlador {
    
   @Resource
   VeterinarioServicio veterinarioServ;
   
   /**
    * Obtiene todos los veterinarios registrados en la base de datos.
    * @return Lista de veterinarios.
    */
   @GetMapping(value= "/veterinarioList")
   public List<Veterinario> getVeterinario(){
       return veterinarioServ.findAll();
   }
   
   /**
    * Obtiene un veterinario de la base de datos dado su RFC.
    * @param RFC RFC del veterinario.
    * @return Veterinario con el RFC especificado. Si no existe, los valores estarán vacíos.
    */
   @GetMapping(value = "/veterinario")
   public Veterinario getVeterinario(@RequestParam String RFC){
       return veterinarioServ.selectVeterinario(RFC);
   }
   
   /**
    * Inserta un nuevo veterinario en la base de datos.
    * @param veterinario Veterinario a insertar.
    */
   @PostMapping(value= "/createVeterinario")
   public void createVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.insertVeterinario(veterinario);
   }
   
   /**
    * Emite una actualización de un veterinario en la base de datos.
    * @param veterinario Veterinario a actualizar.
    */
   @PutMapping(value = "/updateVeterinario")
   public void updateVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.updateVeterinario(veterinario);
   }
   
   /**
    * Ejecuta una operación de actualización de un veterinario en la base de datos.
    * @param veterinario Veterinario a actualizar.
    */
   @PutMapping(value = "/executeUpdateVeterinario")
   public void executeUpdateVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.executeUpdateVeterinario(veterinario);
   }
   
   /**
    * Borra un veterinario de la base de datos.
    * @param veterinario Veterinario a borrar.
    */
   @DeleteMapping(value = "/deleteVeterinarioById")
   public void borrarVeterinario(@RequestBody Veterinario veterinario){
       veterinarioServ.deleteVeterinario(veterinario);
   }
   
}
