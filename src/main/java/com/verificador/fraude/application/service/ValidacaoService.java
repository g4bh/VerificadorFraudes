package com.verificador.fraude.application.service;


import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.useCase.ValidarContatoUC;
import com.verificador.fraude.application.useCase.ValidarDataUC;
import com.verificador.fraude.application.useCase.ValidarIdentidadedUC;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ValidacaoService {

    public String calcularPontuacaoDados(DadosPessoaisDTO dadoPessoais){

        ValidarIdentidadedUC validarIdentidade = new ValidarIdentidadedUC();
        if (!validarIdentidade.validarNome(dadoPessoais.getNomeCompleto()) || (!validarIdentidade.validarNome(dadoPessoais.getNomeMae()))){
            return "Grau de confiabilidade: 0";
        }

        ValidarDataUC validarData = new ValidarDataUC();
        if (!validarData.validarData(dadoPessoais.getDataNascimento())){
            return "Grau de confiabilidade: 0";
        }

        ValidarContatoUC validarContato = new ValidarContatoUC();
        if (!validarContato.validarEmail(dadoPessoais.getEmail()) || (!validarContato.validarTelefone(dadoPessoais.getTelefone()))){
            return "Grau de confiabilidade: 0";
        }


        double confiabilidadeFinal = new Random().nextDouble() * 10;
        return "Grau de confiabilidade: " + String.format("%.2f", confiabilidadeFinal);
    }
}
