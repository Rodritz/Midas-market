package com.midas.market.entity.dto;


import com.midas.market.entity.Categoria;

public record DatosRespuestaProducto(Long id, String nombre, String marca, Categoria categoria,
                                     Double precio, Integer cantidad) {

}
