# RestAPI em Java para um trabalho da disciplina de Desenvolvimento Web

# Desenvolvido por Gabriel Antônio Becher e Matheus Felipe do Rocio D'avila

## O sistema consiste em cadastrar Jogadores e pagamentos mensais para os mesmos

## Rotas de Jogadores

### Get(/api/)

- Retorna todos os jogadores cadastrados

### Post(/api/)

- Recebe os dados de um jogador no formato {nome: "nome", email: "email", datanasc: "dd/MM/yyyy"}

### Put(/api/{cod_jogador})

- Recebe dados a serem atualizados de um jogador

### Delete(/api/{cod_jogador})

- Recebe o id do jogador a ser deletado, se houverem pagamentos atrelados a ele também será deletados

## Rotas de Pagamentos

### Get(/api/pagamentos?nome=nome)

- Retona todos os pagamentos registrados no sistema
  - Retorna todos os pagamentos de um jogador se fornecido um nome

### Post(/api/pagamentos/{id})

- Registra um novo pagamento em um determinado jogador dado um codigo
  - Corpo do pagamento no formato {ano:ano, mes:numMes ,valor:valor}

### Put(/api/pagamentos/{cod_pagamento})

- Recebe dados a serem atualizados de um pagamento

### Delete(/api/pagamentos/{cod_pagamento})

- Recebe um id do pagamento a ser deletado
