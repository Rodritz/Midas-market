package com.midas.market.service;

import com.midas.market.entity.dto.DatosListadoUsuarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    Page<DatosListadoUsuarios> findAll(Pageable paginacion);
}
