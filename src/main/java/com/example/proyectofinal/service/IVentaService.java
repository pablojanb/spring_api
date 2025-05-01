package com.example.proyectofinal.service;

import com.example.proyectofinal.dto.VentaDTO;
import com.example.proyectofinal.dto.VentaMayorDTO;
import com.example.proyectofinal.dto.VentaPorDiaDTO;
import com.example.proyectofinal.model.Producto;
import com.example.proyectofinal.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    Venta getVenta(Long codigo_venta);

    VentaDTO addVenta(Venta venta);

    VentaDTO getVentaDTO(Venta venta, List<Producto> listaDisponibles, List<Producto> listaNoDisponibles);

    void editVenta(Long codigo_venta, Venta venta);

    void deleteVenta(Long codigo_venta);

    double calcularTotalVenta(List<Producto> listaProductos);

    List<Producto> getProductosVenta(Long codigo_venta);

    VentaPorDiaDTO getVentaPorDia(LocalDate fecha_venta);

    VentaMayorDTO getVentaMayor();
}
