package bdd.cenarios;

import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;
import com.verificador.fraude.application.service.ValidacaoService;
import com.verificador.fraude.application.useCase.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.util.Random;

public class ValidacaoTestSteps {

    private ValidarContatoUC validarContato = new ValidarContatoUC();
    private ValidarEnderecoUC validarEndereco = new ValidarEnderecoUC();
    private ValidarIdentidadeUC validarIdentidade = new ValidarIdentidadeUC();
    private ValidarDataUC validarData = new ValidarDataUC();
    public ValidacaoService validacaoService = new ValidacaoService();

    @Dado("que o usuário insere todos os dados corretamente")
    public void InserirDadosUsuario(String email, String telefone, String endereco, String data, String nomeCompleto, String cpf, String nomeMae){
        validarContato.validarEmail("email@email.com");
        validarContato.validarTelefone("13999999999");
        validarEndereco.validarEndereco("Avenida Paulista");
        validarData.validarData("02/03/1997");
        validarIdentidade.validarNome("Leandro Silva");
        validarIdentidade.validarCPF("63638716546");
        validarIdentidade.validarNome("Maria da Luz");
    }

    @Quando("o programa processa esses dados")
    public void ProcessaDadosRecebidos(){

    }

    @Então("o programa retorna um grau de confiabilidade aleatório")
    public void RetornoGrauAleatorio(){
        double confiabilidadeFinal = new Random().nextDouble() * 10;
    }

    @Dado("que o usuário insere alguns dados corretamente")
    public void InserirAlgunsDadosUsuario(){}

    @E("algum dado obrigatório está ausente")
    public void ProcessaComDadosAusente(){

    }

    @Então("o programa retorna um grau de confiabilidade igual a 0")
    public void RetornaGrauZero(){
        var grauConfiabilidade = 0;
    }
}
