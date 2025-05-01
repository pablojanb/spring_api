package com.example.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VentaMayorDTO {
    private Long codigo_venta;
    private Double total;
    private String nombre;
    private String apellido;
    private int cant_productos;
}
