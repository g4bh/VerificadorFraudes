package com.verificador.fraude.application.service;


import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.useCase.ValidarContatoUC;
import com.verificador.fraude.application.useCase.ValidarDataUC;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    double pontuacaoDados = 0;

    public String calcularPontuacaoDados(DadosPessoaisDTO dadoPessoais){
        
        ValidarDataUC validarData = new ValidarDataUC();
        validarData.validarData(dadoPessoais.getDataNascimento());

        ValidarContatoUC validarContato = new ValidarContatoUC();
        validarContato.validarEmail(dadoPessoais.getEmail());
        validarContato.validarTelefone(dadoPessoais.getTelefone());
        
        if (validarData.getPontuacaoData() == 0 || validarContato.getPontuacao() == 0){
            pontuacaoDados = 0;
        }else {
        pontuacaoDados = validarData.getPontuacaoData() + validarContato.getPontuacao();}

        return "Grau de confiabilidade: " + pontuacaoDados;
    }
}
