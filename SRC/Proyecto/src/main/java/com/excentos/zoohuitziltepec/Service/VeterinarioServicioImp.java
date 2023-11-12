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
