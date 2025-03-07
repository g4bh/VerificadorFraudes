package bdd.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verificador.fraude.adapter.api.dto.DadosPessoaisDTO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class DadosPessoaisMock {

    private static final Map<String, Map<String, String>> dadosMock;

    static {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = DadosPessoaisMock.class.getClassLoader().getResourceAsStream("dados.json");

        if (inputStream == null) {
            throw new RuntimeException("Arquivo dados.json não encontrado no classpath!");
        }

        try {
            dadosMock = mapper.readValue(inputStream, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON de mocks", e);
        }
    }

    public static DadosPessoaisDTO getMock(String tipo) {
        Map<String, String> dados = dadosMock.get(tipo);

        if (dados == null) {
            throw new IllegalArgumentException("Tipo de mock não encontrado: " + tipo);
        }

        return new DadosPessoaisDTO(
                dados.get("cpf"),
                dados.get("nomeCompleto"),
                dados.get("telefone"),
                dados.get("email"),
                dados.get("dataNascimento"),
                dados.get("endereco"),
                dados.get("nomeMae")
        );
    }
}
