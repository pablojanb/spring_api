package com.example.proyectofinal.service;

import com.example.proyectofinal.model.Cliente;
import com.example.proyectofinal.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return iClienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id_cliente) {
        return iClienteRepository.findById(id_cliente).orElse(null);
    }

    @Override
    public void addCliente(Cliente cliente) {
        iClienteRepository.save(cliente);
    }

    @Override
    public void editCliente(Long id_cliente, Cliente cliente) {
        Cliente clienteAEditar = this.getCliente(id_cliente);
        clienteAEditar.setNombre(cliente.getNombre());
        clienteAEditar.setApellido(cliente.getApellido());
        clienteAEditar.setDni(cliente.getDni());
        this.addCliente(clienteAEditar);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        iClienteRepository.deleteById(id_cliente);
    }
}
