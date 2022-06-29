<h1 align="center" font-style="bold">
Biblioteca Virtual
</h1>

## 💻 Sobre o projeto

- <p style="color: red;">Aplicação que registras livros e avaliações.</p>

## 👨🏻‍💻 Desenvolvedores

- [Debora Brum](https://github.com/DeboraBrum)

## 🚀 Tecnologias

Tecnologias que utilizamos para desenvolver esta API Rest:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Swagger](https://swagger.io/)

## ▶️ Iniciando

- As instruções a seguir irão te guiar para que você crie uma cópia do projeto na sua máquina local.

### Pré-requisitos

- Configure um banco de dados [PostgreSQL](https://www.postgresql.org/) na sua máquina e crie um novo banco.

**Clone o projeto, e acesse a pasta**

```bash
$ git clone https://github.com/DeboraBrum/treinando-api-livros.git && cd treinando-api-livros
```

**Siga as etapas abaixo**

Edite o arquivo "./src/main/resources/application.properties" com as configurações do seu banco de dados:

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.show_sql = true
springdoc.api-docs.path=/api-docs
```

E rode o projeto na sua IDE.

Tudo pronto! Agora, para uma visão geral da API, basta acessar http://localhost:8080/swagger-ui.html, onde você encontra a documentação de todos os endpoints disponíveis com índice e descrição, numa interface amigável do Swagger, além de poder utiliza-los com requisições e repostas, interagindo com o seu banco de dados local.

No início do projeto, estávamos desenvolvendo a documentação manualmente aqui no README, até termos a ideia de gerá-la automaticamente com o swagger. Ainda assim, mantivemos a documentação manual aqui também no final do README, como registro da mudança, e como outro exemplo de abordagem.

## ⚙️ Funcionalidades

Funcionalidades que a API oferece:
- Cadastro e Login de Usuário
- Criptografia de senhas
- Autenticação de usuário
- Validação de requisições
- Listagem de todos os livros
- Listagem de todos as avaliações
- Registro de avaliação
- Documentação dos endpoints integrada ao código e automatizada, através da springdoc-openapi-ui, o que também facilita atualização.
