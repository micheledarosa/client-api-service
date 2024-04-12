# Client Service API 👤

Este projeto consiste em uma aplicação que permite o registro de clientes e seus respectivos endereços.
Foi desenvolvido utilizando o framework Spring Boot e configurado através do Spring Initializr, com os seguintes módulos selecionados:

- **Spring Data JPA:** Para facilitar a interação com o banco de dados e mapeamento objeto-relacional.
- **Spring Web:** Para criar endpoints RESTful e lidar com requisições HTTP.
- **H2 Database:** Um banco de dados em memória para facilitar o desenvolvimento e os testes.
- **OpenFeign:** Uma biblioteca para facilitar a integração com serviços RESTful externos, neste caso, a API do ViaCEP. 
- **OpenAPI/Swagger:** Para facilitar a compreensão e a usabilidade da API. (Essa dependência foi adicionada manualmente ao projeto)

## Funcionamento ⚙️
Ao cadastrar um novo cliente, a aplicação verifica se o cliente já existe no banco de dados pelo nome. Caso não exista, ela integra com a API do ViaCEP para obter informações completas do endereço a partir do CEP fornecido. Após isso, o cliente é registrado juntamente com seu endereço associado.

## Organização MVC 📂

Essa estrutura segue os princípios do padrão MVC (Model-View-Controller), onde cada camada tem responsabilidades bem definidas e a separação de preocupações é mantida.
```shell
src
└── main
    └── java
        └── one
            └── digitalinnovation
                └── gof
                    ├── controller
                    │   └── ClienteRestController.java
                    ├── exception
                    │   ├── ClienteExistenteException.java
                    │   └── ClienteNaoEncontradoException.java
                    ├── model
                    │   ├── Cliente.java
                    │   ├── ClienteRepository.java
                    │   ├── Endereco.java
                    │   └── EnderecoRepository.java
                    ├── service
                    │    ├── impl
                    │    │   └── ClienteService.java
                    │    └── ViaCepService.java
                    └── Application.java
```

- O pacote `controller` contém os controladores, que são responsáveis por receber as requisições do usuário e chamar os serviços apropriados.

- O pacote `model` contém os modelos de dados do aplicativo, juntamente com os repositórios responsáveis pela interação com o banco de dados.

- O pacote `service` contém os serviços do aplicativo, que encapsulam a lógica de negócios e interagem com os modelos de dados.

- O pacote `exception` contém classes que representam exceções específicas do aplicativo.

## Endpoints 🛤️

Os endpoints descritos abaixo fornecem uma interface clara para as operações básicas de CRUD (Create, Read, Update, Delete) em relação aos clientes.

![Imgur](https://i.imgur.com/DeUhTkS.png)

### Cadastro de Clientes

- **Método:** `POST`
- **Endpoint:** `/clientes`
- **Descrição:** Permite o registro de novos clientes, incluindo informações como nome e CEP. Outros dados, como endereço completo, são automaticamente preenchidos através da integração com a API ViaCEP.
- **Corpo da Requisição:** Deve conter as informações do cliente, incluindo nome e CEP, no formato JSON.

### Consulta de Clientes

- **Método:** `GET`
- **Endpoint:** `/clientes`
- **Descrição:** Retorna todos os clientes registrados.

### Busca por Cliente Específico

- **Método:** `GET`
- **Endpoint:** `/clientes/{id}`
- **Descrição:** Retorna as informações de um cliente específico com base no seu ID.

### Atualização de Clientes

- **Método:** `PUT`
- **Endpoint:** `/clientes/{id}`
- **Descrição:** Permite a atualização dos dados de um cliente registrado.
- **Corpo da Requisição:** Deve conter as informações atualizadas do cliente no formato JSON.

### Exclusão de Clientes

- **Método:** `DELETE`
- **Endpoint:** `/clientes/{id}`
- **Descrição:** Permite a exclusão de um cliente registrado a partir do seu ID.

