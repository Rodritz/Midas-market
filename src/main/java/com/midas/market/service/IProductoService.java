package com.midas.market.service;

import com.midas.market.entity.dto.DatosActualizacionProducto;
import com.midas.market.entity.dto.DatosRegistroProducto;
import com.midas.market.entity.dto.DatosRespuestaProducto;
import com.midas.market.entity.dto.DatosListadoProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public interface IProductoService {

    DatosRespuestaProducto saveProduct(DatosRegistroProducto datosRegistroProducto);
    DatosRespuestaProducto updateProduct(Long id, DatosActualizacionProducto datosActualizacionProducto);

    void deleteProduct(Long id);

    void desactivarProducto(Long id);

    DatosRespuestaProducto activarProduct(Long id);

    URI buildProductUri(UriComponentsBuilder uriComponentsBuilder, Long id);

    Page<DatosListadoProducto> findAllActivos(Pageable paginacion);
}
