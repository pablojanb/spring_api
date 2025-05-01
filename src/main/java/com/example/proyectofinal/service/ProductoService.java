package com.example.proyectofinal.service;

import com.example.proyectofinal.model.Producto;
import com.example.proyectofinal.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public List<Producto> getProductos() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long codigo_producto) {
        return iProductoRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public void addProducto(Producto producto) {
        iProductoRepository.save(producto);
    }

    @Override
    public void editProducto(Long codigo_producto, Producto producto) {
        Producto productoAEditar = this.getProducto(codigo_producto);
        productoAEditar.setNombre(producto.getNombre());
        productoAEditar.setMarca(producto.getMarca());
        productoAEditar.setCosto(producto.getCosto());
        productoAEditar.setCantidad_disponible(producto.getCantidad_disponible());
        this.addProducto(productoAEditar);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        iProductoRepository.deleteById(codigo_producto);
    }

    @Override
    public double checkearStock(Long codigo_producto) {
        return this.getProducto(codigo_producto).getCantidad_disponible();
    }
}
