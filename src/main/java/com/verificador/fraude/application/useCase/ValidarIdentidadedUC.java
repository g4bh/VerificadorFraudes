package com.verificador.fraude.application.useCase;

import static com.verificador.fraude.domain.constants.Constants.REGEX_DIGITOS;
import static com.verificador.fraude.domain.constants.Constants.REGEX_NOME;

public class ValidarIdentidadedUC extends ValidarContatoUC {

    public boolean validarNome(String nome){
        if(nome == null || nome.trim().isEmpty() || nome.trim().length() < 2){
            return false;
        }

        if(!nome.matches(REGEX_NOME)) return false;

        return true;
    }


    public boolean validarCPF(String cpf){

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 && validaDigitos(cpf)) {
            return false;
        }

        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += digito * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }


        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += digito * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        int digito1Informado = cpf.charAt(9) - '0';
        int digito2Informado = cpf.charAt(10) - '0';

        return primeiroDigito == digito1Informado && segundoDigito == digito2Informado;

    }


}
