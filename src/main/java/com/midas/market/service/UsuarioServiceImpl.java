package com.midas.market.service;

import com.midas.market.entity.dto.DatosListadoUsuarios;
import com.midas.market.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Page<DatosListadoUsuarios> findAll(Pageable paginacion) {
        return usuarioRepository.findAll(paginacion).map(DatosListadoUsuarios::new);
    }
}
