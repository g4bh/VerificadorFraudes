package com.verificador.fraude.application.useCase;

import static com.verificador.fraude.domain.constants.Constants.*;

public class ValidarContatoUC {

    public static boolean validarTelefone(String telefone) {
        if (telefone == null) return false;

        telefone = telefone.replaceAll("\\D", "");

        if (!validaDigitos(telefone)) return false;

        return telefone.length() == 11 && validaDDD(telefone);
    }

    public static boolean validarEmail(String email){
        return email != null && email.matches(REGEX_EMAIL);
    }

    private static boolean validaDDD(String telefone){
        String DDD = telefone.substring(2, 4);
        return DDD.matches(REGEX_DDD);
    }

    public static boolean validaDigitos(String telefone){
        return telefone.matches(REGEX_DIGITOS);
    }

}
