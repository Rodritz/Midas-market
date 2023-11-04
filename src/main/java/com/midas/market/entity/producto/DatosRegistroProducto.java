package com.midas.market.entity.producto;

import com.midas.market.config.exceptions.InvalidEnumException;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;


public record DatosRegistroProducto(

        @NotBlank(message = "{nombre.obligatorio}")
        String nombre,
        @NotBlank(message = "{marca.obligatorio}")
        String marca,
        @NotNull(message = "{categoria.obligatorio}")
        Categoria categoria,
        @NotNull(message = "{precio.obligatorio}")
        @Positive(message = "{precio.positivo}")
        Double precio,
        @NotNull(message = "{cantidad.obligatorio}")
        @PositiveOrZero(message = "{cantidad.positiva}")
        Integer cantidad) {


}
