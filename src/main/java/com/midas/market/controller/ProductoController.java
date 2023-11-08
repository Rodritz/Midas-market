package com.midas.market.controller;

import com.midas.market.entity.dto.DatosActualizacionProducto;
import com.midas.market.entity.dto.DatosRegistroProducto;
import com.midas.market.entity.dto.DatosRespuestaProducto;
import com.midas.market.entity.dto.DatosListadoProducto;
import com.midas.market.service.ProductoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;


    @GetMapping("/listar")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE')")
    @Operation(summary = "Obtiene el listado de productos")
    public ResponseEntity<Page<DatosListadoProducto>> findAll(@PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable paginacion) {
        Page<DatosListadoProducto> productos = productoService.findAllActivos(paginacion);
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Registra un nuevo producto")
    public ResponseEntity<DatosRespuestaProducto> saveProduct(@Valid @RequestBody DatosRegistroProducto datosRegistroProducto,
                                                              UriComponentsBuilder uriComponentsBuilder) {

        DatosRespuestaProducto datosRespuestaProducto = productoService.saveProduct(datosRegistroProducto);
        URI url = productoService.buildProductUri(uriComponentsBuilder, datosRespuestaProducto.id());

        return ResponseEntity.created(url).body(datosRespuestaProducto);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    @Operation(summary = "Actualiza la informacion de un producto")
    public ResponseEntity<DatosRespuestaProducto> updateProduct(@PathVariable Long id,
            @Valid @RequestBody DatosActualizacionProducto datosActualizacionProducto) {
        DatosRespuestaProducto datosRespuestaProducto = productoService.updateProduct(id,
                datosActualizacionProducto);

        return ResponseEntity.ok(datosRespuestaProducto);
    }


    @PutMapping("/desactivar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Pasa un producto a estado Inactivo mediante el id")
    public ResponseEntity deleteLogico(@PathVariable Long id) {
        productoService.desactivarProducto(id);

        String mensaje = String.format("El producto con ID %d se desactivo correctamente.", id);

        return ResponseEntity.noContent().header("mensaje", mensaje).build();
    }

    @PutMapping("/activar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    @Operation(summary = "Pasa un producto a estado Activo mediante el id")
    public ResponseEntity<DatosRespuestaProducto> activarProducto(@PathVariable Long id) {
        DatosRespuestaProducto datosRespuestaProducto = productoService.activarProduct(id);

        return ResponseEntity.ok(datosRespuestaProducto);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    @Operation(summary = "Elimina un producto de la base de datos")
    public ResponseEntity deleteProducto(@PathVariable Long id) {
        productoService.deleteProduct(id);

        String mensaje = String.format("El producto con ID %d se elimino correctamente.", id);

        return ResponseEntity.noContent().header("mensaje", mensaje).build();
    }


}
