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

    ValidarIdentidadeUC validarIdentidade = new ValidarIdentidadeUC();

    @Test
    void validarNomeCompletoCorretamente() {
        assertEquals(true, validarIdentidade.validarNome("Gabriella Santos"));
    }
}