package com.verificador.fraude.adapter.api.controller;


import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.service.ValidacaoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/antifraude")
public class AntiFraudeController {
    private final ValidacaoService validacaoService;

    public AntiFraudeController(ValidacaoService antiFraudeService) {
        this.validacaoService = antiFraudeService;
    }

    @PostMapping("/avaliar")
    public String avaliarDados(@RequestBody DadosPessoaisDTO dados) {
        return validacaoService.calcularPontuacaoDados(dados);
    }
}
