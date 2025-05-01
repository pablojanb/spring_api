package com.example.proyectofinal.service;

import com.example.proyectofinal.dto.VentaDTO;
import com.example.proyectofinal.model.Producto;
import com.example.proyectofinal.model.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    Venta getVenta(Long codigo_venta);

    VentaDTO addVenta(Venta venta);

    void editVenta(Long codigo_venta, Venta venta);

    void deleteVenta(Long codigo_venta);

    double calcularTotalVenta(List<Producto> listaProductos);
}
