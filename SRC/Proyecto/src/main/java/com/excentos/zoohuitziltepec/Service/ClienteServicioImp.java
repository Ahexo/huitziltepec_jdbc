/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.excentos.zoohuitziltepec.Service;

import com.excentos.zoohuitziltepec.Repository.ClienteRepositorio;
import com.excentos.zoohuitziltepec.Model.Cliente;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ahexo
 */
@Service
public class ClienteServicioImp implements ClienteServicio {
    
    @Resource
    ClienteRepositorio clienteRepo;
            
    @Override
    public List<Cliente> findAll() {
        return clienteRepo.findAll(); 
    }

    @Override
    public void insertCliente(Cliente cliente) {
        clienteRepo.insertCliente(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepo.updateCliente(cliente);
    }

    @Override
    public void executeUpdateCliente(Cliente cliente) {
        clienteRepo.executeUpdateCliente(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteRepo.deleteCliente(cliente);
    }
    
}
