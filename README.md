
# Sistema de transferência monetária

Bem-vindo ao Pay.me, um aplicação que simula transferências por PIX! baseado no desafio de backend do PicPay.
Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetado para simular um sistema bancário mais simples. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub.


## Visão Geral

Este sistema foi desenvolvido para gerenciar transações bancárias e saldo de usuários. Cada conta pode ser atribuída a um único usuário, e cada usuário possui apenas uma conta. As principais funcionalidades incluem:

* Cadastro de usuário com nome, cpf/cnpj, email e tipo do usuário (Comum ou Lojista).
* Gerenciamento de contas que guarda o saldo do usuário e registra as transações.
* Gerenciamento de transações, que registra o valor transferido, a data/hora da transferência e o usuário recebedor e pagador.


## Tecnologias Utilizadas

* Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
* Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
* Flyway: Para gerenciamento de migrações do banco de dados.
* JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
* Git: Controle de versão para gerenciamento de mudanças no código.
* GitHub: Hospedagem do repositório para controle de versão.
* Spring Data JPA: Para interação com o banco de dados.
* Maven: Para build e gerenciamento de dependências do projeto.
* SQL: Manipulação do banco de dados

## Design do Banco de Dados
O esquema do banco de dados segue as seguintes relações:

* Conta: Contém atributos como id, saldo, usuário (dono) e histórico de transações.
* Um usuário possui apenas uma conta e uma conta pertence a apenas um usuário
* Usuário: Contém atributos como id, nome, cpf/cnpj, email, tipo e conta.

## Configuração
* Clone o repositório: git clone git@github.com:adkasima/pay.me.git
* Navegue até o diretório do projeto: cd pay.me
* Construa o projeto: mvn clean install
* Execute a aplicação: mvn spring-boot:run
* Acesse a aplicação em http://localhost:8080
* Acesse a documentação da aplicação em http://localhost:8080/swagger-ui/index.html
