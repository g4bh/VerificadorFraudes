package com.verificador.fraude.application.useCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class ValidarDataUC {

    double pontuacaoData = 0;

    private static final List<DateTimeFormatter> FORMATOS_DATA = Arrays.asList(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy")
    );

    public void validarData(String dataNascimento){
        if (!verificaFormato(dataNascimento)){
            pontuacaoData = 0;
            return;
        }
        pontuacaoData = 1;
    }

    private boolean verificaFormato(String dataNascimento) {
        for (DateTimeFormatter formato : FORMATOS_DATA) {
            try {
                LocalDate data = LocalDate.parse(dataNascimento, formato);
                LocalDate hoje = LocalDate.now();
                return data.isBefore(hoje);
            } catch (DateTimeParseException e) {}
        }
        return false;
    }

    public double getPontuacaoData() {
        return pontuacaoData;
    }
}
