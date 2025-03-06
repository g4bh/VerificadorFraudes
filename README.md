## Verificador AntiFraude 

Este projeto consiste na construção de um protótipo de um microsserviço antifraude. O principal objetivo é receber dados pessoais, validar os dados inseridos na aplicação, e retornar um grau de confiabilidade aleatório, em base no que foi recebido/inserido pelo usuário.

## Como o projeto foi construído?
![Group 1 (1)](https://github.com/user-attachments/assets/55737af8-eb7a-4871-a9c4-916e149040b8)

Por meio da API, o microsserviço recebe os dados pessoais do usuário em formato JSON. A aplicação processa cada campo recebido, realiza as validações necessárias e, ao final, retorna um valor booleano (True ou False) indicando se os dados são válidos ou não.

### Exemplo de entrada de dados em JSON

```
{
	"cpf":"856.405.118-42",
	"nomeCompleto": "Antônio Santos",
	"telefone": "15999999999",
	"email": "antonio@gmail.com",
	"dataNascimento": "26/02/2001",
	"endereco": "Avenida Palmeiras",
	"nomeMae": "Maria dos Santos"
}
```



## Como utilizar?

### Acessando remoto

Para utilizar o microsserviço, você pode fazer requisições HTTP utilizando ferramentas como Insomnia, Postman ou qualquer outro cliente de API. A requisição deve ser feita com o método **POST** para o seguinte endpoint: 

```
https://verificadorfraudes-production.up.railway.app/antifraude/avaliar
```

![image](https://github.com/user-attachments/assets/aa1f28b6-7e91-47af-923f-843d8ad2cfd0)

Após a validação dos dados, a API retornará uma mensagem indicando o grau de confiabilidade dos dados:

```
Grau de confiabilidade: 8.29
```

---

### Acessando local

- Clone o repositório:
```
https://github.com/g4bh/VerificadorFraudes
```

- Instale as depêndencias (se necessário):
```
mvn install
```
> Para rodar o projeto, é necessário ter o Java 21 instalado em seu dispositivo

- Execute o projeto:
```
mvn spring-boot:run
```

- No Insominia/Postman/Outro aplicativo, acesse a api em:
```
 http://localhost:8080/antifraude/avaliar
```

## Graus de confiabilidade

- **Dados inválidos ou inconsistentes**: Se houver inconsistências ou erros nos dados inseridos, o grau de confiabilidade será **0**, indicando que os dados não são confiáveis.

- **Dados válidos**: Se os dados estiverem corretos, o grau de confiabilidade será gerado aleatoriamente, variando entre **0** e **10**.



## Tecnologias utilizadas

- API: Spring Boot 3.4.1
- Aplicação: Java 21
- Testes unitário: Mockito e JUnit 5
- Behavior Driven Development: Cucumber 7.14.0

----

Esse projeto foi desenvolvido para o desafio de código para a RT - Onboarding de Clientes. 🧡
