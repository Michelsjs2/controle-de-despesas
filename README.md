# Controle de Despesas em Memória via CLI
Projeto desenvolvido em Java, fazendo uso de todo conhecimento pré-POO (estrutura de dados simples como arrays, estruturas condicionais e laços de repetição), em busca de consolidar tais conhecimentos fundamentais da linguagem e de programação no geral. 
<br>

## Funcionalidades
**- Cadastro de despesas:** Registra a descrição, categoria e valor da despesa. Com validação no valor, impedindo que o usuário registre uma despesa com valor menor ou igual a 0. Cada ponto da despesa registrado é inserido em um diferente array.
<br><br>
**- Relatório Geral:** Pega todas as despesas registradas e as exibe com suas devidas informações, além de também informar ao usuário qual foi o valor total gasto, a média do valor de cada lançamento registrado, qual foi a sua maior despesa, como está o gasto de acordo com o orçamento (nesse caso um valor fixo) e quantos espaços se encontram disponíveis nos arrays para novos cadastros (o limite é 5).
<br><br>
**- Filtro por Categoria:** E por fim, a última funcionalidade é o filtro por categoria onde o usuário deseja qual categoria de gastos deseja verificar e com isso ele recebe as informações referentes as despesas cadastradas na categoria, além de ser informado do valor subtotal gasto naquela categoria junto com a porcentagem do quanto aquele subtotal vale em relação ao valor total gasto.
<br>

## Restrições Técnicas
Este projeto foi desenvolvido **intencionalmente sem o uso de classes de domínio, `ArrayList` ou blocos `try-catch`**, com o objetivo de exercitar o controle manual de índices, estado e algoritmos básicos.<br>

## Exemplo de Execução (Output)
Abaixo está um exemplo completo de interação no console demonstrando o cadastro de despesas, validação de valor inválido, geração do relatório geral e filtro por categoria:

```text
==============================
  CONTROLE DE DESPESAS (0/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 1
--- Nova Despesa ---
Descrição: Mercado
Categoria: Alimentacao
Valor: 250.50
Despesa cadastrada com sucesso!

==============================
  CONTROLE DE DESPESAS (1/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 1
--- Nova Despesa ---
Descrição: Cafe
Categoria: Alimentacao
Valor: -15.00
Erro: o valor deve ser maior que zero.

==============================
  CONTROLE DE DESPESAS (1/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 1
--- Nova Despesa ---
Descrição: Conta de Luz
Categoria: Moradia
Valor: 180.00
Despesa cadastrada com sucesso!

==============================
  CONTROLE DE DESPESAS (2/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 1
--- Nova Despesa ---
Descrição: Restaurante
Categoria: Alimentacao
Valor: 94.50
Despesa cadastrada com sucesso!

==============================
  CONTROLE DE DESPESAS (3/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 2
=== RELATORIO GERAL DE DESPESAS ===
1. [ALI] Mercado - R$ 250.50
2. [MOR] Conta de Luz - R$ 180.00
3. [ALI] Restaurante - R$ 94.50
-----------------------------------
Total gasto: R$ 525.00
Media por lancamento: R$ 175.00
Maior despesa: Mercado (R$ 250.50)
Status - Atenção: gaste moderadamente 
Vagas restantes na memória: 2

==============================
  CONTROLE DE DESPESAS (3/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 3
Digite a categoria para filtrar: alimentacao
=== FILTRO: ALIMENTACAO ===
- Mercado: R$ 250.50
- Restaurante: R$ 94.50
Subtotal da categoria: R$ 345.00 (65.71% do total)

==============================
  CONTROLE DE DESPESAS (3/5)
==============================
1. Cadastrar despesa
2. Exibir relatorio geral
3. Filtrar por categoria
4. Sair
Escolha uma opção: 4
Encerrando o sistema...
```
