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
    List<Veterinario> findAll();
    void insertVeterinario(Veterinario veterinario);
    void updateVeterinario(Veterinario veterinario);
    void executeUpdateVeterinario(Veterinario veterinario);
    void deleteVeterinario(Veterinario veterinario); 
}
