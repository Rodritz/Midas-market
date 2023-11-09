package com.midas.market.repository;

import com.midas.market.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Usuario usuario =
                Usuario.builder()
                        .nombre("Juan")
                        .apellido("Perez")
                        .email("juanPerez@gmail.com")
                        .build();
        testEntityManager.persist(usuario);
    }

    @Test
    @DisplayName("Usuario encontrado por email Ok!!")
    void findUserByEmailOk() {
        Optional<Usuario> usuario = usuarioRepository.findUserByEmail("juanPerez@gmail.com");
        assertEquals(usuario.get().getEmail(), "juanPerez@gmail.com");
    }

    @Test
    @DisplayName("Usuario encontrado por email Failed!!")
    void findUserByEmailNotOk() {
        Optional<Usuario> usuario = usuarioRepository.findUserByEmail("juanRamirez@gmail.com");
        assertEquals(usuario, Optional.empty());
    }

    @Test
    @DisplayName("El mail del usuario existe?  Ok!!!")
    void existsByEmailOk() {
        String existingEmail = "juanPerez@gmail.com";

        boolean exists = usuarioRepository.existsByEmail(existingEmail);

        assertTrue(exists, "User with email " + existingEmail + " should exist");
    }

    @Test
    @DisplayName("El mail del usuario existe?  Failed!!")
    void existsByEmailNotOk() {
        String nonExistingEmail = "juanRamirez@gmail.com";

        boolean exists = usuarioRepository.existsByEmail(nonExistingEmail);

        assertFalse(exists, "User with email " + nonExistingEmail + " should not exist");
    }
}