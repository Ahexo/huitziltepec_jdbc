/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Service;

import com.excentos.zoohuitziltepec.Repository.VeterinarioRepositorio;
import com.excentos.zoohuitziltepec.Model.Veterinario;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahexo
 */
@Service
public class VeterinarioServicioImp implements VeterinarioServicio {
    
    @Resource
    VeterinarioRepositorio veterinarioRepo;
    
    @Override
    public List<Veterinario> findAll() {
        return veterinarioRepo.findAll();
    }

    @Override
    public void insertVeterinario(Veterinario veterinario) {
        veterinarioRepo.insertVeterinario(veterinario);
    }

    @Override
    public void updateVeterinario(Veterinario veterinario) {
        veterinarioRepo.updateVeterinario(veterinario);
    }

    @Override
    public void executeUpdateVeterinario(Veterinario veterinario) {
        veterinarioRepo.executeUpdateVeterinario(veterinario);
    }

    @Override
    public void deleteVeterinario(Veterinario veterinario) {
        veterinarioRepo.deleteVeterinario(veterinario);
    }
    
}
