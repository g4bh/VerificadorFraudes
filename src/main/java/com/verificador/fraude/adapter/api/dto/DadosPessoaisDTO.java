package com.verificador.fraude.adapter.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DadosPessoaisDTO {
    private String cpf;
    private String nomeCompleto;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String endereco;
    private String nomeMae;
}
