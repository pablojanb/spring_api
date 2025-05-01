package com.example.proyectofinal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VentaPorDiaDTO {
    private int cantidad_ventas;
    private double total_ventas;
}
