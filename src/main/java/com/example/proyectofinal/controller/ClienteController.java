package com.example.proyectofinal.controller;

import com.example.proyectofinal.model.Cliente;
import com.example.proyectofinal.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return iClienteService.getClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return iClienteService.getCliente(id_cliente);
    }

    @PostMapping("/clientes/crear")
    public String addCliente(@RequestBody Cliente cliente){
        iClienteService.addCliente(cliente);
        return "Cliente creado correctamente";
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente,
                              @RequestBody Cliente cliente){
        iClienteService.editCliente(id_cliente, cliente);
        return "Cliente editado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        iClienteService.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }
}
