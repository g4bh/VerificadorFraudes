package com.verificador.fraude.application.useCase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidarIdentidadeUCTest {

    ValidarIdentidadeUC validarIdentidade = new ValidarIdentidadeUC();

    @Test
    void validarNomeCompletoCorretamente(){
        assertEquals(true, validarIdentidade.validarNome("Gabriella Santos"));
    }

}
