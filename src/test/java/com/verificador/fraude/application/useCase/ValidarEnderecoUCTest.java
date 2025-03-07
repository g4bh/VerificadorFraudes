package com.verificador.fraude.application.useCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = ValidarEnderecoUC.class
)
@ActiveProfiles("test")
public class ValidarEnderecoUCTest {
    private RestTemplate restTemplateMock;
    private ValidarEnderecoUC validarEnderecoUC;

    @BeforeEach
    void setUp() {
        restTemplateMock = mock(RestTemplate.class);

        validarEnderecoUC = new ValidarEnderecoUC();
    }

    @Test
    void inserirEnderecoValido() {
        String jsonResponse = "{ \"results\": [{}] }";
        ResponseEntity<String> response = new ResponseEntity<>(jsonResponse, HttpStatus.OK);

        when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenReturn(response);

        boolean resultado = validarEnderecoUC.validarEndereco("Avenida Paulista, São Paulo");
        assertTrue(resultado);
    }

    @Test
    void inserirEnderecoInvalido() {
        String jsonResponse = "{ \"results\": [] }";
        ResponseEntity<String> response = new ResponseEntity<>(jsonResponse, HttpStatus.OK);

        when(restTemplateMock.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class)))
                .thenReturn(response);

        boolean resultado = validarEnderecoUC.validarEndereco("Rua Nada Haver De Jó, Cidade Fake");
        assertFalse(resultado);
    }

}
