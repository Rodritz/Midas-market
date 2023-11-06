package com.midas.market.entity.dto;

import com.midas.market.entity.Categoria;
import com.midas.market.service.Update;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;

@Validated(Default.class)
public record DatosActualizacionProducto(
        @NotNull(groups = Update.class)
        Long id,

        @NotBlank(message = "{nombre.obligatorio}", groups = Update.class)
        String nombre,
        @NotBlank(message = "{marca.obligatorio}", groups = Update.class)
        String marca,

        @NotNull(message = "{categoria.obligatoria}", groups = Update.class)
        @Enumerated(EnumType.STRING)
        Categoria categoria,

        @NotNull(message = "{precio.obligatorio}", groups = Update.class)
        @Positive(message = "{precio.positivo}")
        Double precio,

        @NotNull(message = "{cantidad.obligatorio}", groups = Update.class)
        @PositiveOrZero(message = "{cantidad.positiva}")
        Integer cantidad
) {}

