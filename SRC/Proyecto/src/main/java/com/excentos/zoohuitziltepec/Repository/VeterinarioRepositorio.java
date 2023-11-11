/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.excentos.zoohuitziltepec.Repository;

import com.excentos.zoohuitziltepec.Model.Veterinario;
import java.util.List;

/**
 *
 * @author ahexo
 */
public interface VeterinarioRepositorio {
    List<Veterinario> findAll();
    void insertVeterinario(Veterinario veterinario);
    void updateVeterinario(Veterinario veterinario);
    void executeUpdateVeterinario(Veterinario veterinario);
    public void deleteVeterinario(Veterinario veterinario); 
}
