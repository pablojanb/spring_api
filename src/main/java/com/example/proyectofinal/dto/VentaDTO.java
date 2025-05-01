package com.example.proyectofinal.dto;

import com.example.proyectofinal.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VentaDTO {
    private LocalDate fecha_venta;
    private Double total;
    private List<Long> listaProductosDisponibles;
    private List<Long> listaProductosNoDisponibles;
}
