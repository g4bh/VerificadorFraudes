package com.verificador.fraude.application.useCase;

import static com.verificador.fraude.domain.constants.Constants.REGEX_DIGITOS;
import static com.verificador.fraude.domain.constants.Constants.REGEX_NOME;

public class ValidarIdentidadeUC extends ValidarContatoUC {

    public static boolean validarNome(String nome){
        if(nome == null || nome.trim().isEmpty() || nome.trim().length() < 2){
            return false;
        }
        if(!nome.matches(REGEX_NOME)) return false;
        return true;
    }


    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf == null || !cpf.matches(REGEX_DIGITOS)) {
            return false;
        }

        if (cpf.length() != 11 || digitosIguais(cpf)) {
            return false;
        }

        return validarDigitosCPF(cpf);
    }

    private static boolean digitosIguais(String cpf) {
        char primeiroDigito = cpf.charAt(0);
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != primeiroDigito) {
                return false;
            }
        }
        return true;
    }

    private static boolean validarDigitosCPF(String cpf) {
        return calcularDigito(cpf, 9) == (cpf.charAt(9) - '0') &&
                calcularDigito(cpf, 10) == (cpf.charAt(10) - '0');
    }

    private static int calcularDigito(String cpf, int posicao) {
        int soma = 0;
        for (int i = 0; i < posicao; i++) {
            soma += (cpf.charAt(i) - '0') * ((posicao + 1) - i);
        }
        int resultado = 11 - (soma % 11);
        return (resultado > 9) ? 0 : resultado;
    }


}
