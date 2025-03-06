package bdd.cenarios;

import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.service.ValidacaoService;
import io.cucumber.java.pt.Dado;

public class ValidacaoTestSteps {

    public ValidacaoService validacaoService = new ValidacaoService();

    @Dado("que os dados inseridos pelo usuário estejam corretos")
    public void InserirDadosUsuario(){
    }
}
