package com.midas.market.repository;

import com.midas.market.entity.Categoria;
import com.midas.market.entity.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductoRepositoryTest {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

        productoRepository.deleteAll();

        Producto producto1 = new Producto(1L,"Jabon", "Dove", Categoria.HOGAR, 200.0, 1, true);
        Producto producto2 = new Producto(2L,"Jabon", "Rexona", Categoria.HOGAR, 180.0, 1, false);
        Producto producto3 = new Producto(3L,"Jabon", "Plusbell", Categoria.HOGAR, 200.0, 1, true);

        productoRepository.saveAll(List.of(producto1, producto2, producto3));

    }

    @Test
    @DisplayName("Usuarios activos encontrados  Ok!!")
    void findByActivoTrueOk() {
        Page<Producto> page = productoRepository.findByActivoTrue(PageRequest.of(0, 10));

        assertEquals(2, page.getTotalElements());
    }

    @Test
    @DisplayName("Usuarios activos encontrados  Failed!!")
    void findByActivoTrueNotOk() {
        Page<Producto> page = productoRepository.findByActivoTrue(PageRequest.of(0, 10));

        assertNotEquals(3, page.getTotalElements());
    }


}