package com.midas.market.controller;

import com.midas.market.entity.producto.*;
import com.midas.market.repository.ProductoRepository;
import com.midas.market.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping
    @Operation(summary = "Obtiene el listado de productos")
    public ResponseEntity<Page<DatoslistadoProducto>> findAll(@PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable paginacion) {
        Page<DatoslistadoProducto> productos = productoService.findAllActivos(paginacion);
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    @Operation(summary = "Registra un nuevo producto")
    public ResponseEntity<DatosRespuestaProducto> saveProduct(@Valid @RequestBody DatosRegistroProducto datosRegistroProducto,
            UriComponentsBuilder uriComponentsBuilder) {

        DatosRespuestaProducto datosRespuestaProducto = productoService.saveProduct(datosRegistroProducto);
        URI url = productoService.buildProductUri(uriComponentsBuilder, datosRespuestaProducto.id());

        return ResponseEntity.created(url).body(datosRespuestaProducto);
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Actualiza la informacion de un producto")
    public ResponseEntity<DatosRespuestaProducto> updateProduct(@PathVariable Long id,
            @Valid @RequestBody DatosActualizacionProducto datosActualizacionProducto) {
        DatosRespuestaProducto datosRespuestaProducto = productoService.updateProduct(id,
                datosActualizacionProducto);

        return ResponseEntity.ok(datosRespuestaProducto);
    }


    @PutMapping("/desactivar/{id}")
    @Operation(summary = "Pasa un producto a estado Inactivo mediante el id")
    public ResponseEntity deleteLogico(@PathVariable Long id) {
        productoService.desactivarProducto(id);

        String mensaje = String.format("El producto con ID %d se desactivo correctamente.", id);

        return ResponseEntity.noContent().header("mensaje", mensaje).build();
    }

    @PutMapping("/activar/{id}")
    @Transactional
    @Operation(summary = "Pasa un producto a estado Activo mediante el id")
    public ResponseEntity<DatosRespuestaProducto> activarProducto(@PathVariable Long id) {
        DatosRespuestaProducto datosRespuestaProducto = productoService.activarProduct(id);

        return ResponseEntity.ok(datosRespuestaProducto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProducto(@PathVariable Long id) {
        productoService.deleteProduct(id);

        String mensaje = String.format("El producto con ID %d se elimino correctamente.", id);

        return ResponseEntity.noContent().header("mensaje", mensaje).build();
    }


}
