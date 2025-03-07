#language: pt

Funcionalidade: Calcular grau de confiabilidade com base nos dados inseridos

  Cenario: Inserção de dados válidos
    Dado que o usuário insere todos os dados corretamente
    Então o programa retorna um grau de confiabilidade aleatório

  Cenario: Inserção de dados válidos, mas com campos faltando
    Dado que o usuário não insere alguns dados corretamente
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenario: Inserção de dados incorretos
    Dado que o usuário insere dados inválidos
    Então o programa retorna um grau de confiabilidade igual a 0

  Esquema do Cenário: Teste com diferentes endereços inválidos
    Dado que o usuário insere um "<endereco>" não existente
    Então o programa retorna um grau de confiabilidade igual a 0
    Exemplos:
      | endereco                 |
      | Rua Abluble              |
      | Avenida dos cachorros    |
      | Rua Jujubinha            |
