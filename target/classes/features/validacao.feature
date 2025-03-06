#language: pt

Funcionalidade: Retornar grau de confiabilidade com dados inseridos

  Cenario: Inserido dados validos
    Dado um grupo de dados válidos
    Quando o programa processa esses dados
    Entao retorna um grau de confiabilidade aleatório


  Cenario1.0: Dados inseridos corretamente pelo usuário
    Dado que os dados inseridos estão corretos
    E nenhum dado está