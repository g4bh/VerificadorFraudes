package com.verificador.fraude.application.service;


import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.useCase.ValidarContatoUC;
import com.verificador.fraude.application.useCase.ValidarDataUC;
import com.verificador.fraude.application.useCase.ValidarEnderecoUC;
import com.verificador.fraude.application.useCase.ValidarIdentidadedUC;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ValidacaoService {

    public String calcularPontuacaoDados(DadosPessoaisDTO dadoPessoais){

        ValidarIdentidadedUC validarIdentidade = new ValidarIdentidadedUC();
        ValidarDataUC validarData = new ValidarDataUC();
        ValidarContatoUC validarContato = new ValidarContatoUC();
        ValidarEnderecoUC validarEndereco = new ValidarEnderecoUC();


        if (!validarIdentidade.validarNome(dadoPessoais.getNomeCompleto()) ||
                (!validarIdentidade.validarNome(dadoPessoais.getNomeMae()) ||
                        (!validarData.validarData(dadoPessoais.getDataNascimento()) ||
                                (!validarContato.validarEmail(dadoPessoais.getEmail()) ||
                                        (!validarContato.validarTelefone(dadoPessoais.getTelefone()) ||
                                                (!validarIdentidade.validarCPF(dadoPessoais.getCpf()) ||
                                                        (!validarEndereco.validarEndereco(dadoPessoais.getEndereco())))))))){
            return "Grau de confiabilidade: 0";
        }


        double confiabilidadeFinal = new Random().nextDouble() * 10;
        return "Grau de confiabilidade: " + String.format("%.2f", confiabilidadeFinal);
    }
}
