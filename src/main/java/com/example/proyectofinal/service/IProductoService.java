package com.example.proyectofinal.service;

import com.example.proyectofinal.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getProductos();

    Producto getProducto(Long codigo_producto);

    void addProducto(Producto producto);

    void editProducto(Long codigo_producto, Producto producto);

    void deleteProducto(Long codigo_producto);

    double checkearStock(Long codigo_producto);
}
