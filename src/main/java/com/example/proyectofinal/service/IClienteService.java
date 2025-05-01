package com.example.proyectofinal.service;

import com.example.proyectofinal.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getClientes();

    Cliente getCliente(Long id_cliente);

    void addCliente(Cliente cliente);

    void editCliente(Long id_cliente, Cliente cliente);

    void deleteCliente(Long id_cliente);
}
