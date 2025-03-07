package com.verificador.fraude.application.useCase;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = ValidarContatoUC.class
)
@ActiveProfiles("test")
public class ValidarContatoUCTest {

    @Test
    void testValidarTelefoneValido() {
        assertTrue(ValidarContatoUC.validarTelefone("11987654321"));
    }

    @Test
    void testValidarTelefoneInvalido() {
        assertFalse(ValidarContatoUC.validarTelefone("12345"));
        assertFalse(ValidarContatoUC.validarTelefone("awdygwaydg"));
    }

    @Test
    void testValidarEmailValido() {
        assertTrue(ValidarContatoUC.validarEmail("email@teste.com"));
    }

    @Test
    void testValidarEmailInvalido() {
        assertFalse(ValidarContatoUC.validarEmail("email.com"));
        assertFalse(ValidarContatoUC.validarEmail("email@.com"));
    }
}
