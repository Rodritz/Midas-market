package com.midas.market.entity.dto;

import com.midas.market.entity.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;


public record DatosRegistroProducto(

        @NotBlank(message = "{nombre.obligatorio}")
        String nombre,
        @NotBlank(message = "{marca.obligatorio}")
        String marca,
        @NotNull(message = "{categoria.obligatorio}")
        @Enumerated(EnumType.STRING)
        Categoria categoria,
        @NotNull(message = "{precio.obligatorio}")
        @Positive(message = "{precio.positivo}")
        Double precio,
        @NotNull(message = "{cantidad.obligatorio}")
        @PositiveOrZero(message = "{cantidad.positiva}")
        Integer cantidad) {


}
