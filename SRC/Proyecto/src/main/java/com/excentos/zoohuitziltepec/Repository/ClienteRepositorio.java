/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.excentos.zoohuitziltepec.Repository;

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.util.List;

/**
 *
 * @author ahexo
 */
public interface ClienteRepositorio {
    List<Cliente> findAll();
    void insertCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void executeUpdateCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente); 
}
