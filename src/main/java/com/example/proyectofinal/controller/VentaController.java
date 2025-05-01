package com.example.proyectofinal.controller;

import com.example.proyectofinal.dto.VentaDTO;
import com.example.proyectofinal.model.Venta;
import com.example.proyectofinal.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService iVentaService;

    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return iVentaService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta){
        return iVentaService.getVenta(codigo_venta);
    }

    @PostMapping("/ventas/crear")
    public VentaDTO addVenta(@RequestBody Venta venta){
        return iVentaService.addVenta(venta);
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public String editVenta(@PathVariable Long codigo_venta,
                               @RequestBody Venta venta){
        iVentaService.editVenta(codigo_venta, venta);
        return "Venta editada correctamente";
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        iVentaService.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }
}
