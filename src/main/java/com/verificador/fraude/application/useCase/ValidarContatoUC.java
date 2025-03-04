package com.verificador.fraude.application.useCase;

import static com.verificador.fraude.domain.constants.Constants.*;

public class ValidarContatoUC {

    double pontuacaoContato;

    public void validarTelefone(String telefone){
        if (telefone.startsWith("55")){
            if (!validaDDD(telefone)) { pontuacaoContato = 0; return;}
            if (!validaDigitos(telefone)) {{ pontuacaoContato = 0;}}
        }
        else {
            pontuacaoContato = 0;
        }
    }

    public void validarEmail(String email){
        if(email.matches(REGEX_EMAIL)){
            pontuacaoContato += 1;
        }else {
            pontuacaoContato = 0;
        }

    }

    private boolean validaDDD(String telefone){
        String DDD = telefone.substring(2, 4);
        return DDD.matches(REGEX_DDD);
    }

    private boolean validaDigitos(String telefone){
        return telefone.matches(REGEX_DIGITOS);
    }

    public double getPontuacao(){
        return pontuacaoContato;
    }

}
