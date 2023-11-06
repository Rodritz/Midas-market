package com.midas.market.entity.dto;

import com.midas.market.entity.Rol;
import com.midas.market.entity.Usuario;

public record DatosListadoUsuarios(Long id, String nombre, String apellido, String email, Rol rol) {

    public DatosListadoUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getApellido(),
                usuario.getEmail(), usuario.getRol());
    }
}
