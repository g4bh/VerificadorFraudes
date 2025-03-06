#language: pt

Funcionalidade: Retornar grau de confiabilidade com dados inseridos

  Cenario: Inserção de dados validos
    Dado que o usuário insere todos os dados corretamente
    Quando o programa processa esses dados
    Entao retorna um grau de confiabilidade aleatório

  Cenario1.0: Dados inseridos corretamente pelo usuário
    Dado que os dados inseridos pelo usuário estejam corretos
    E nenhum dado esteja faltando
    Então o programa retorna um grau de confiabilidade aleatória

  Cenario2.0: Dados inseridos corretamente pelo usuário mas há dados faltando
    Dado que os dados inseridos pelo usuário estejam corretos
    E algum dado esteja faltando na inserção
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenario3.0: Dados inseridos incorremante pelo usuário
    Dado que os dados inseridos pelo usuário estejam incorretos
    E nenhum dado esteja faltando
    Então o programa retorna um grau de confiabilidade igual a 0

  Cenario4.0: O endereço inserido pelo usuário não é encontrado
    Dado que os dados inseridos pelo usuário estejam corretos
    Quando não há dados faltando na inserção
    E o <endereco> retorna como false
    Então o programa retorna um grau de confiabilidade igual a 0
  Exemplo:
      | endereco      |
      | rua jujubinha |