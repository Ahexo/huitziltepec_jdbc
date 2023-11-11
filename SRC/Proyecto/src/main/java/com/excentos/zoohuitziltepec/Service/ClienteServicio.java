/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.excentos.zoohuitziltepec.Service;

import com.excentos.zoohuitziltepec.Model.Cliente;
import java.util.List;

/**
 *
 * @author ahexo
 */
public interface ClienteServicio {
    List<Cliente> findAll();
    void insertCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void executeUpdateCliente(Cliente cliente);
    void deleteCliente(Cliente cliente);
}
