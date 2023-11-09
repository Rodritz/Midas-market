package com.midas.market.service;

import com.midas.market.entity.Categoria;
import com.midas.market.entity.Producto;
import com.midas.market.entity.dto.DatosActualizacionProducto;
import com.midas.market.entity.dto.DatosRegistroProducto;
import com.midas.market.entity.dto.DatosRespuestaProducto;
import com.midas.market.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductoServiceImplTest {

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("Registro de producto OK!!")
    void saveProduct() {
        DatosRespuestaProducto product = new DatosRespuestaProducto(6L,"Jabon", "Dove", Categoria.HOGAR, 200.0, 1);
        DatosRegistroProducto newProduct = new DatosRegistroProducto("Jabon", "Dove", Categoria.HOGAR, 200.0, 1);

        DatosRespuestaProducto act = productoService.saveProduct(newProduct);

        assertEquals(product,act);
    }

    @Test
    @DisplayName("Actualizacion de producto Ok!!")
    void updateProduct() {
        DatosActualizacionProducto updatedProductData = new DatosActualizacionProducto(1L,"Shampoo", "Head & Shoulders", Categoria.HOGAR, 150.0, 2);

        Producto existingProduct = productoRepository.findById(1L).orElseThrow();

        DatosRespuestaProducto actualResponse = productoService.updateProduct(1L, updatedProductData);

        DatosRespuestaProducto expectedResponse = new DatosRespuestaProducto(1L, "Shampoo", "Head & Shoulders", Categoria.HOGAR, 150.0, 2);
        assertEquals(expectedResponse, actualResponse);

    }
}