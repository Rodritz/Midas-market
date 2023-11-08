package com.midas.market.service;

import com.midas.market.entity.*;
import com.midas.market.entity.dto.DatosActualizacionProducto;
import com.midas.market.entity.dto.DatosListadoProducto;
import com.midas.market.entity.dto.DatosRegistroProducto;
import com.midas.market.entity.dto.DatosRespuestaProducto;
import com.midas.market.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;


@Service
public class ProductoServiceImpl implements IProductoService {


    @Autowired
    ProductoRepository productoRepository;

    public Page<DatosListadoProducto> findAllActivos(Pageable paginacion) {
        return productoRepository.findByActivoTrue(paginacion).map(DatosListadoProducto::new);
    }

    public DatosRespuestaProducto saveProduct(DatosRegistroProducto datosRegistroProducto) {

        Producto producto = productoRepository.save(new Producto(datosRegistroProducto));
            DatosRespuestaProducto datosRespuestaProducto = new DatosRespuestaProducto(
                    producto.getId(), producto.getNombre(),
                    producto.getMarca(), producto.getCategoria(),
                    producto.getPrecio(), producto.getCantidad());

            return datosRespuestaProducto;
    }

    public URI buildProductUri(UriComponentsBuilder uriComponentsBuilder, Long id) {
        return uriComponentsBuilder.path("/productos/{id}")
                .buildAndExpand(id).toUri();
    }


    @Override
    public DatosRespuestaProducto updateProduct(Long id, DatosActualizacionProducto datosActualizacionProducto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID " + id));

        producto.setNombre(Objects.nonNull(datosActualizacionProducto.nombre()) ? datosActualizacionProducto.nombre() : producto.getNombre());
        producto.setMarca(Objects.nonNull(datosActualizacionProducto.marca()) ? datosActualizacionProducto.marca() : producto.getMarca());
        producto.setCategoria(Objects.nonNull(datosActualizacionProducto.categoria()) ? datosActualizacionProducto.categoria() : producto.getCategoria());
        producto.setPrecio(Objects.nonNull(datosActualizacionProducto.precio()) ? datosActualizacionProducto.precio() : producto.getPrecio());
        producto.setCantidad(Objects.nonNull(datosActualizacionProducto.cantidad()) ? datosActualizacionProducto.cantidad() : producto.getCantidad());

        productoRepository.save(producto);

        return new DatosRespuestaProducto(producto.getId(), producto.getNombre(),
                producto.getMarca(), producto.getCategoria(), producto.getPrecio(), producto.getCantidad());
    }

    @Override
    public void deleteProduct(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID %d: " + id));
        productoRepository.delete(producto);
    }

    @Transactional
    @Override
    public void desactivarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID %d: " + id));

        if (producto.getActivo()==false ) {
            throw new IllegalStateException("El producto con ID " + id + " ya está inactivo.");
        }
        producto.setActivo(false);
        productoRepository.save(producto);
    }

    @Override
    public DatosRespuestaProducto activarProduct(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID " + id));

        if (producto.getActivo()==true ) {
            throw new IllegalStateException("El producto con ID " + id + " ya está activo.");
        }
        producto.setActivo(true);
        productoRepository.save(producto);

        return new DatosRespuestaProducto(producto.getId(), producto.getNombre(),
                producto.getMarca(), producto.getCategoria(), producto.getPrecio(), producto.getCantidad());
    }
}
