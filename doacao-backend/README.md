# doacao-backend


## Tecnologias Usadas
- Java 8
- SpringBoot

## Buildando o projeto localmente
- Compilar o projeto
- DoacaobackendApplication.java é o arquivo que deve ser executado para subir a aplicação localmente

## Teste de funcionalidade
- Chamada HTTP nos controladores

## Banco de Dados
- Atualmente não temos um banco de dados modelado

## Gitflow
- Master fica com o código final do projeto
- Develop é atualizada ao fim de cada Sprint
- Branch de Sprint é criada a partir de Develop
- Branches de US são criadas a partir da branch de Sprint
- Branches de TASK são criadas a partir das branches de US
- Com todas as branches de TASK mergeadas na de US, a US pode ser mergeada na branch da Sprint, e com a Sprint encerrada e validada, a mesma é mergeada em Develop.

## Padrão de Commit
- [USXX Nome Inicial Tarefa:feature]: Quando for criar uma nova funcionalidade, colocar o número da TASK e o indicador de "feature".
- [USXX Nome Inicial Tarefa:fix] Quando for corrigir um bug, ou corrigir alguma coisa, colocar o número da TASK e o indicador de "fix".
- [USXX Nome Inicial Tarefa:docs] Quando for alterar uma documentação, colocar o número da TASK e o indicador de "docs".

## Ambiente Heroku 
- https://doacao-app-backend.herokuapp.com
- Essa URL está a aplicação rodando, já com um banco de dados dedicado, basta realizar uma chamada para este endereço que o mesmo retornará os dados (atualmente mockados)


product e item é a mesma coisa