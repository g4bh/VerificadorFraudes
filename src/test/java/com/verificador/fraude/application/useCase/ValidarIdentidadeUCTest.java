package com.verificador.fraude.application.useCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = ValidarIdentidadeUC.class
)
@ActiveProfiles("test")
public class ValidarIdentidadeUCTest {

    @Test
    void testValidarNomeValido() {
        assertTrue(ValidarIdentidadeUC.validarNome("João Silva"));
    }

    @Test
    void testValidarNomeInvalido() {
        assertFalse(ValidarIdentidadeUC.validarNome("A"));
        assertFalse(ValidarIdentidadeUC.validarNome("1234"));
    }

    @Test
    void testValidarCPFValido() {
        assertTrue(ValidarIdentidadeUC.validarCPF("12345678909"));
    }

    @Test
    void testValidarCPFInvalido() {
        assertFalse(ValidarIdentidadeUC.validarCPF("11111111111"));
        assertFalse(ValidarIdentidadeUC.validarCPF("123"));
    }
}