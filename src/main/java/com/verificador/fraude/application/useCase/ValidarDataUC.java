package com.verificador.fraude.application.useCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class ValidarDataUC {

    private static final List<DateTimeFormatter> FORMATOS_DATA = Arrays.asList(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy")
    );

    public static boolean validarData(String dataNascimento){
        if (!verificaFormato(dataNascimento)){
            return false;
        }
        return true;
    }

    private static boolean verificaFormato(String dataNascimento) {
        for (DateTimeFormatter formato : FORMATOS_DATA) {
            try {
                LocalDate data = LocalDate.parse(dataNascimento, formato);
                LocalDate hoje = LocalDate.now();
                return data.isBefore(hoje);
            } catch (DateTimeParseException e) {}
        }
        return false;
    }

}
