package com.midas.market.service;

import com.midas.market.entity.producto.DatosActualizacionProducto;
import com.midas.market.entity.producto.DatosRegistroProducto;
import com.midas.market.entity.producto.DatosRespuestaProducto;
import com.midas.market.entity.producto.DatoslistadoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public interface ProductoService {

    DatosRespuestaProducto saveProduct(DatosRegistroProducto datosRegistroProducto);
    DatosRespuestaProducto updateProduct(Long id, DatosActualizacionProducto datosActualizacionProducto);

    void deleteProduct(Long id);

    void desactivarProducto(Long id);

    DatosRespuestaProducto activarProduct(Long id);

    URI buildProductUri(UriComponentsBuilder uriComponentsBuilder, Long id);

    Page<DatoslistadoProducto> findAllActivos(Pageable paginacion);
}
