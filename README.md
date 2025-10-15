# 🚀 Portfólio CRUD API de Funcionários

Este projeto é uma API RESTful para gerenciamento de funcionários, implementando todas as operações CRUD (Create, Read, Update, Delete). Desenvolvida com Spring Boot 3.x e Spring Data JPA, a aplicação utiliza o padrão de arquitetura em camadas para garantir a organização e escalabilidade.

## 🛠️ Tecnologias Utilizadas

* Java	Versão 21 <br>
* Spring Boot	Framework principal para construção da API REST. <br>
* Spring Data JPA	Para persistência de dados e operações CRUD simplificadas.<br>
* MySQL	Banco de dados relacional utilizado para armazenamento.<br>
* Lombok	Biblioteca para reduzir código boilerplate (getters, setters, construtores).<br>
* SpringDoc OpenAPI	Gera a documentação automática (Swagger UI) para testar os endpoints. <br>
* Maven	Gerenciador de dependências e build.<br>
* Postman	Ferramenta utilizada para testar e interagir com os endpoints da API.



## 📦Configuração e Execução

Para rodar a API em seu ambiente local, siga os passos abaixo:

Pré-requisitos

* JDK 21 ou superior instalado.
* Um servidor MySQL acessível.
* Maven configurado (ou use a integração de sua IDE).

**1. Configurar o Banco de Dados**

* Crie um banco de dados no MySQL (Ex: portifolio_db).

* Configure as credenciais de acesso no arquivo de propriedades do Spring (application.properties ou application.yml).

**Exemplo de Configuração:**

## 📝 Properties

 **Exemplo em application.properties**
 
spring.datasource.url=jdbc:mysql://localhost:3306/portifolio_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC <br>
spring.datasource.username=seu_usuario_mysql<br>
spring.datasource.password=sua_senha_mysql<br>
spring.jpa.hibernate.ddl-auto=update # Cria/atualiza a tabela 'funcionarios' automaticamente<br>

**2. Executar a Aplicação** <br>
A aplicação pode ser iniciada diretamente pela sua IDE (executando a classe principal) ou via terminal:

**Bash**

 **Empacotar o projeto**
 
```mvn clean package ```

## Executar o arquivo JAR gerado

java -jar target/portifolio-0.0.1-SNAPSHOT.jar <br>
A API estará em execução na porta padrão do Spring: http://localhost:8080.<br>

🧭 **Documentação e Endpoints**
Após a execução, a documentação interativa (Swagger UI) estará disponível no seu navegador:

🔗 **Documentação (Swagger UI):** http://localhost:8080/swagger-ui.html

**Modelo de Dados (Funcionarios)**
A entidade Funcionarios representa a tabela no banco de dados com a seguinte estrutura:

JSON

{
  "id": 1,
  "name": "Nome Completo",
  "idade": 30,
  "cpf": "123.456.789-00",
  "cargo": "Desenvolvedor Java"
}
Endpoints (CRUD)
O prefixo de todos os endpoints é /funcionarios.

Método HTTP	Endpoint	Descrição	Status de Sucesso
POST	/funcionarios	Cria um novo funcionário.	200 OK (ou 201 Created)
GET	/funcionarios	Lista todos os funcionários.	200 OK
GET	/funcionarios/{id}	Busca um funcionário pelo ID.	200 OK
PUT	/funcionarios/{id}	Atualiza completamente o funcionário pelo ID.	200 OK
DELETE	/funcionarios/{id}	Remove um funcionário pelo ID.	200 OK ou 204 No Content


Exemplo de Requisição POST (Criação)
URL: POST http://localhost:8080/funcionarios

Body (JSON):

JSON

{
  "name": "Maria Oliveira",
  "idade": 28,
  "cpf": "000.111.222-33",
  "cargo": "Analista de RH"
}
Exemplo de Requisição PUT (Atualização)
URL: PUT http://localhost:8080/funcionarios/1

Body (JSON):

JSON

{
  "name": "Maria Oliveira (Atualizada)",
  "idade": 29,
  "cpf": "000.111.222-33",
  "cargo": "Gerente de RH"
}
⚙️ **Estrutura do Projeto**
O projeto segue a estrutura padrão do Spring Boot:

com.crud.portifolio.controller: Contém a classe FuncionariosController, responsável por receber e rotear as requisições HTTP (camada de apresentação).

com.crud.portifolio.entity: Contém a classe Funcionarios, que representa o modelo de dados (tabela) no banco de dados.

com.crud.portifolio.repository: Contém a interface FuncionariosRepository que, ao estender JpaRepository, fornece todos os métodos de CRUD para interagir com o MySQL (camada de persistência).
