package com.midas.market.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "{nombre.obligatorio}")
    private String nombre;

    @NotBlank(message = "{apellido.obligatorio}")
    private String apellido;

    @NotNull
    @Email(message = "{email.obligatorio}")
    private String email;

    @NotNull
    @Pattern(regexp = "^[0-9]+$", message = "{password.obligatorio}")
    private String password;
}
