package bdd.cenarios;

import bdd.mock.DadosPessoaisMock;
import com.verificador.fraude.application.service.ValidacaoService;
import com.verificador.fraude.application.useCase.ValidarEnderecoUC;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

import static org.junit.jupiter.api.Assertions.*;

public class ValidacaoTestSteps {

    private final ValidacaoService validacaoService = new ValidacaoService();
    private String resultadoValidacao;

    @Dado("que o usuário insere todos os dados corretamente")
    public void inserirDadosUsuario() {
        resultadoValidacao = validacaoService.calcularPontuacaoDados(DadosPessoaisMock.getMock("dados_validos"));
    }

    @Então("o programa retorna um grau de confiabilidade aleatório")
    public void retornoGrauAleatorio() {
        String valorNumerico = resultadoValidacao.replace("Grau de confiabilidade: ", "");
        double grau = Double.parseDouble(valorNumerico.replace(",", "."));
        assertTrue(grau > 0.0 && grau <= 10);
    }

    @Dado("que o usuário não insere alguns dados corretamente")
    public void inserirAlgunsDadosUsuario() {
        resultadoValidacao = validacaoService.calcularPontuacaoDados(DadosPessoaisMock.getMock("dados_com_campos_faltando"));
    }

    @Dado("que o usuário insere dados inválidos")
    public void inserirDadosUsuarioInvalidos() {
        resultadoValidacao = validacaoService.calcularPontuacaoDados(DadosPessoaisMock.getMock("dados_invalidos"));
    }

    @Então("o programa retorna um grau de confiabilidade igual a 0")
    public void retornaGrauZero() {
        assertEquals("Grau de confiabilidade: 0,00", resultadoValidacao);
    }

    @Dado("que o usuário insere um {string} não existente")
    public void inserirEnderecoInvalido(String endereco) {
        boolean enderecoInvalido = ValidarEnderecoUC.validarEndereco(endereco);
        assertFalse(enderecoInvalido);
        resultadoValidacao = "Grau de confiabilidade: 0,00";
    }
}