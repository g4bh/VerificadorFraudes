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
        classes = ValidarDataUC.class
)
@ActiveProfiles("test")
public class ValidarDataUCTest {

    @Test
    void testValidarDataValida() {
        assertTrue(ValidarDataUC.validarData("01-01-2000"));
        assertTrue(ValidarDataUC.validarData("10/10/1999"));
    }

    @Test
    void testValidarDataInvalida() {
        assertFalse(ValidarDataUC.validarData("32-01-2000"));
        assertFalse(ValidarDataUC.validarData("99/99/9999"));
        assertFalse(ValidarDataUC.validarData("26/02/2050"));
    }
}
