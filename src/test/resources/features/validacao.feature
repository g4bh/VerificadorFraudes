#language: pt

Funcionalidade: Calcular grau de confiabilidade com base nos dados inseridos

  Cenário0.0: Inserção de dados válidos
    Dado que o usuário insere todos os dados corretamente
    Quando o programa processa esses dados
    Então o programa retorna um grau de confiabilidade aleatório

  Cenário1.0: Inserção de dados válidos, mas com campos faltando
    Dado que o usuário insere alguns dados corretamente
    E algum dado obrigatório está ausente
    Quando o programa processa esses dados
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenário2.0: Inserção de dados incorretos
    Dado que o usuário insere dados inválidos
    Quando o programa processa esses dados
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenário3.0: O endereço inserido pelo usuário não é encontrado
    Dado que o usuário insere um endereço
    Quando o endereço não é encontrado na base de dados da API
    E a API retorna um responseBody vazio
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenário4.0: Teste com diferentes endereços inválidos
    Dado que o usuário insere um endereço não existente
    Quando o programa tenta validar esse endereço
    Então o programa retorna um grau de confiabilidade igual a 0
    Exemplos:
      | endereco         |
      | Rua Desconhecida |
      | Avenida Falsa    |
      | Rua Jujubinha    |
