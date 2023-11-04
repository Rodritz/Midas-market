package com.midas.market.entity.producto;



public record DatosRespuestaProducto(Long id, String nombre, String marca, Categoria categoria,
                                     Double precio, Integer cantidad) {

}
