package com.midas.market.entity.dto;

import com.midas.market.entity.Categoria;
import com.midas.market.entity.Producto;

public record DatosListadoProducto(Long id, String nombre, Categoria categoria, String marca, Double precio, Integer cantidad) {

    public DatosListadoProducto(Producto producto) {
        this(producto.getId(), producto.getNombre(),producto.getCategoria(),
                producto.getMarca(), producto.getPrecio(), producto.getCantidad());
    }
}
