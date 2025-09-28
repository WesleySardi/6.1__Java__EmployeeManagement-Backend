# Teste Prático de Programação em Java

## Descrição do Projeto

Este projeto foi desenvolvido em Java com o objetivo de praticar conceitos de orientação a objetos, manipulação de listas, streams e formatação de dados.  

O foco é gerenciar uma lista de funcionários, realizando operações como inserção, remoção, agrupamento, ordenação e cálculo de informações relacionadas a salários e datas de nascimento.

## Estrutura do Projeto

O projeto contém as seguintes classes principais:

- **Pessoa**: classe base com os atributos:
  - `nome` (String)
  - `dataNascimento` (LocalDate)

- **Funcionario**: herda de `Pessoa` e adiciona os atributos:
  - `salario` (BigDecimal)
  - `funcao` (String)

- **Principal** (ou `FuncionarioController`): classe responsável por executar a lógica principal do programa, incluindo a chamada de serviços para manipulação dos funcionários.

- **FuncionarioService**: classe que encapsula a lógica de negócio, como:
  - Remover funcionários
  - Aplicar aumento salarial
  - Agrupar funcionários por função
  - Ordenar e filtrar listas
  - Calcular salários mínimos e totais

- **FuncionarioSeed**: classe responsável por gerar os dados iniciais (seed) de teste dos funcionários.

## Requisitos Implementados

O programa realiza as seguintes ações:

1. Inserir todos os funcionários com as informações iniciais.
2. Remover um funcionário específico da lista.
3. Imprimir todos os funcionários, formatando:
   - Data de nascimento no padrão `dd/MM/yyyy`
   - Salário com separador de milhar e decimal no padrão brasileiro
4. Aplicar aumento salarial de 10% a todos os funcionários.
5. Agrupar funcionários por função em um `Map<String, List<Funcionario>>`.
6. Imprimir funcionários agrupados por função.
7. Listar funcionários que fazem aniversário nos meses de outubro e dezembro.
8. Identificar e imprimir o funcionário mais velho, exibindo nome e idade.
9. Imprimir a lista de funcionários em ordem alfabética.
10. Calcular e imprimir o total dos salários de todos os funcionários.
11. Calcular quantos salários mínimos cada funcionário recebe, considerando o salário mínimo de R$1212,00.
