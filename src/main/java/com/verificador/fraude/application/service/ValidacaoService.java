package com.verificador.fraude.application.service;

import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.useCase.*;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ValidacaoService {

    public String calcularPontuacaoDados(DadosPessoaisDTO dadosPessoais) {
        boolean valido = ValidarIdentidadeUC.validarNome(dadosPessoais.getNomeCompleto()) &&
                ValidarIdentidadeUC.validarNome(dadosPessoais.getNomeMae()) &&
                ValidarIdentidadeUC.validarCPF(dadosPessoais.getCpf()) &&
                ValidarDataUC.validarData(dadosPessoais.getDataNascimento()) &&
                ValidarContatoUC.validarEmail(dadosPessoais.getEmail()) &&
                ValidarContatoUC.validarTelefone(dadosPessoais.getTelefone()) &&
                ValidarEnderecoUC.validarEndereco(dadosPessoais.getEndereco());

        double confiabilidadeFinal = valido ? new Random().nextDouble() * 10 : 0;
        return "Grau de confiabilidade: " + String.format("%.2f", confiabilidadeFinal);
    }
}
