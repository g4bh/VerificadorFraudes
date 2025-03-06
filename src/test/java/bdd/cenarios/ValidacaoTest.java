package bdd.cenarios;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/validacao.feature",
        glue = "bdd.cenarios"
)
public class ValidacaoTest {
}
