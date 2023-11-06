package com.midas.market.repository;

import com.midas.market.entity.Producto;
import com.midas.market.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findUserByEmail(String email);
    boolean existsByEmail(String email);
}
