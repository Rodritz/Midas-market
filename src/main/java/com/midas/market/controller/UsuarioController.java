package com.midas.market.controller;

import com.midas.market.entity.dto.DatosListadoUsuarios;
import com.midas.market.service.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    @Operation(summary = "Obtiene el listado de usuarios")
    public ResponseEntity<Page<DatosListadoUsuarios>> findAll(@PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable paginacion) {
        Page<DatosListadoUsuarios> usuarios = usuarioService.findAll(paginacion);
        return ResponseEntity.ok(usuarios);
    }
}