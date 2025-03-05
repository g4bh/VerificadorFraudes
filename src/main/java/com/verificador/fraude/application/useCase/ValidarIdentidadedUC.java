package com.verificador.fraude.application.useCase;

import static com.verificador.fraude.domain.constants.Constants.REGEX_NOME;

public class ValidarIdentidadedUC {

    public boolean validarNome(String nome){
        if(nome == null || nome.trim().isEmpty() || nome.trim().length() < 2){
            return false;
        }

        if(!nome.matches(REGEX_NOME)) return false;

        return true;
    }

}
