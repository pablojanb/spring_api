package com.example.proyectofinal.service;

import com.example.proyectofinal.dto.VentaDTO;
import com.example.proyectofinal.model.Producto;
import com.example.proyectofinal.model.Venta;
import com.example.proyectofinal.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository iVentaRepository;

    @Autowired
    private IProductoService iProductoService;

    @Override
    public List<Venta> getVentas() {
        return iVentaRepository.findAll();
    }

    @Override
    public Venta getVenta(Long codigo_venta) {
        return iVentaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public VentaDTO addVenta(Venta venta) {
        List<Producto> listaProductos = venta.getListaProductos();
        List<Producto> listaDisponibles = new ArrayList<Producto>();
        List<Producto> listaNoDisponibles = new ArrayList<Producto>();
        for (Producto producto : listaProductos) {
            Producto prod = iProductoService.getProducto(producto.getCodigo_producto());
            if (iProductoService.checkearStock(producto.getCodigo_producto()) > 0) {
                listaDisponibles.add(producto);
                Producto productoActualizado = prod;
                productoActualizado.setCantidad_disponible(prod.getCantidad_disponible() - 1);
                iProductoService.editProducto(prod.getCodigo_producto(), productoActualizado);
            } else {
                listaNoDisponibles.add(producto);
            }
        }
        venta.setListaProductos(listaDisponibles);
        venta.setFecha_venta(LocalDate.now());
        venta.setTotal(this.calcularTotalVenta(listaDisponibles));
        iVentaRepository.save(venta);

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setFecha_venta(venta.getFecha_venta());
        ventaDTO.setTotal(venta.getTotal());
        List<Long> listaDtoDisponibles = new ArrayList<>();
        List<Long> listaDtoNoDisponibles = new ArrayList<>();
        for (Producto prod : listaDisponibles) {
            listaDtoDisponibles.add(prod.getCodigo_producto());
        }
        for (Producto prod : listaNoDisponibles) {
            listaDtoNoDisponibles.add(prod.getCodigo_producto());
        }
        ventaDTO.setListaProductosDisponibles(listaDtoDisponibles);
        ventaDTO.setListaProductosNoDisponibles(listaDtoNoDisponibles);
        return ventaDTO;

    }

    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        Venta ventaAEditar = this.getVenta(codigo_venta);
        ventaAEditar.setFecha_venta(venta.getFecha_venta());
        ventaAEditar.setUnCliente(venta.getUnCliente());
        ventaAEditar.setListaProductos(venta.getListaProductos());
        ventaAEditar.setTotal(venta.getTotal());
        this.addVenta(ventaAEditar);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        iVentaRepository.deleteById(codigo_venta);
    }

    @Override
    public double calcularTotalVenta(List<Producto> listaProductos) {
        double total = 0;
        for (Producto producto : listaProductos) {
            Producto prod = iProductoService.getProducto(producto.getCodigo_producto());
            total += prod.getCosto();
        }
        return total;
    }
}
