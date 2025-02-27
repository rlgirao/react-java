# Projeto CEP e Logs (React-Vite com Java-Spring)

Este repositório contém dois projetos: um frontend em React e um backend em Java (Spring Boot). Abaixo estão as instruções para rodar ambos os projetos e acessar a documentação da API.

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em sua máquina:

1. Caso utilize Docker:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

2. Caso rode diretamente:

- [Node.js](https://nodejs.org/) (versão 20 ou superior)
- [IDE React](https://code.visualstudio.com/docs/setup/windows) (Rodar frontend)
- [IDE Java](https://eclipseide.org/) (Rodar backend)
- [MySql](https://www.mysql.com/downloads/) (Banco de dados)
- [SGBD](https://dbeaver.io/download/) (Acessar banco de dados)
- [Requisições](https://www.postman.com/downloads/) (Consumir apis)

## Rodando o Projeto Frontend (React - Vite) Com Docker

1. Navegue até o diretório do projeto frontend:

   ```sh
   cd frontend

2. Execute o comando no terminal:

  ```sh
  docker-compose up -d --build

3. Para verificar se o projeto esta rodando pode executar os seguintes comandos:

- Verificar nome da imagem:

  ```sh
  docker ps

- Após pegar o nome da imagem execute o comando abaixo para exibir os logs:

  ```sh
  docker logs -f nome-imagem

4. Acesse a url no seu frontend:

- http://localhost:5173

## Rodando o Projeto Backend (Java - Spring com MySql) Com Docker

1. Navegue até o diretório do projeto backend:

   ```sh
   cd backend
   cd teste-embracon

2. Execute o comando no terminal:

  ```sh
  docker-compose up -d --build

3. Para verificar se o projeto esta rodando pode executar os seguintes comandos:

- Verificar nome da imagem:

  ```sh
  docker ps

- Após pegar o nome da imagem execute o comando abaixo para exibir os logs:

  ```sh
  docker logs -f nome-imagem

4. Acesse a url no seu backend:

- http://localhost:8080

## Rodando o Projeto Front (React - Vite) direto

1. Navegue até o diretório do projeto frontend:

   ```sh
   cd frontend

2. Instale as dependências do projeto:

   ```sh
   npm install

3. Inicie o servidor de desenvolvimento:

   ```sh
   npm run dev

4. Acesse a url no seu fontend:

- http://localhost:5173

## Rodando o Projeto Backend (Java - Spring com MySql) direto

1. Navegue até o diretório do projeto backend:

   ```sh
   cd backend
   cd teste-embracon

2. Acesse o seu workspace no eclipse e limpe o cache e atualize as dependencias Maven

3. Acesse a url no seu backend:

- http://localhost:8080

## Executar script de banco de dados

1. Navegue até o diretório do projeto backend:

   ```sh
   cd backend

2. Utilize o SGBD de sua preferencia e acesse seu banco de dados e execute o script de criação das tabelas:

  ```sh
  criacao-tabela.sql

3. Em caso de duvidas as credenciais do banco de dados estão no arquivo de docker-compose e application-properties.


## Executar endpoints no postman

1. Navegue até o diretório do projeto backend:

   ```sh
   cd backend

2. A collection com todas as apis estão nesse diretorio, é só importar dentro da sua ferramenta de requisição:

   ```sh
   APIs Embracon.postman_collection.json

