package com.midas.market.entity.producto;

public record DatoslistadoProducto(Long id, String nombre, Categoria categoria,String marca,Double precio,Integer cantidad) {

    public DatoslistadoProducto(Producto producto) {
        this(producto.getId(), producto.getNombre(),producto.getCategoria(),
                producto.getMarca(), producto.getPrecio(), producto.getCantidad());
    }
}
