package com.example.proyectofinal.controller;

import com.example.proyectofinal.model.Producto;
import com.example.proyectofinal.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return iProductoService.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return iProductoService.getProducto(codigo_producto);
    }

    @PostMapping("/productos/crear")
    public String addProducto(@RequestBody Producto producto){
        iProductoService.addProducto(producto);
        return "Producto creado correctamente";
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto,
                              @RequestBody Producto producto){
        iProductoService.editProducto(codigo_producto, producto);
        return "Producto editado correctamente";
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        iProductoService.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }
}
