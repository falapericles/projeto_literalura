# 📚 Literalura

**Literalura** é uma aplicação Java desenvolvida com Spring Boot para buscar e gerenciar informações de livros e autores utilizando uma API externa e um banco de dados PostgreSQL para armazenamento e consultas. O projeto facilita a pesquisa, armazenamento e exibição de informações literárias de forma simplificada e eficiente.

## ✨ Funcionalidades

1. **🔍 Buscar e salvar livros da web:**
   - Pesquisa livros por título ou nome de autor utilizando a API externa [Gutendex](https://gutendex.com).
   - Verifica se o livro ou autor já está cadastrado no banco de dados antes de realizar o salvamento.

2. **📚 Listar todos os livros armazenados:**
   - Exibe todos os livros que estão no banco de dados com suas respectivas informações.

3. **📖 Buscar por livros no banco de dados:**
   - Pesquisa livros cadastrados no banco de dados utilizando uma busca parcial pelo título.

4. **📝 Listar autores cadastrados:**
   - Lista todos os autores registrados no banco de dados.

5. **📅 Listar autores vivos em um determinado ano:**
   - Exibe autores que estavam vivos no ano especificado.

6. **🌐 Estatísticas sobre idiomas:**
   - Conta quantos livros existem no banco de dados para um idioma específico, a partir da sigla fornecida (exemplo: "en" para inglês).

## 💻 Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 3.x**: Framework para a construção do backend da aplicação.
- **PostgreSQL**: Banco de dados relacional para armazenamento persistente dos dados.
- **Maven**: Ferramenta de gerenciamento de dependências e construção do projeto.
- **API Gutendex**: API pública para buscar informações sobre livros.

## 🗄️ Configuração do Banco de Dados

A aplicação utiliza um banco de dados PostgreSQL para persistir os dados. A conexão com o banco de dados é configurada no arquivo `application.properties`:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

### ⚙️ Passos para criar o banco de dados

Antes de executar a aplicação, é necessário criar o banco de dados `livros` no PostgreSQL:

1. Acesse o console do PostgreSQL:
   ```bash
   psql -U postgres
   ```

2. Crie o banco de dados:
   ```sql
   CREATE DATABASE livros;
   ```

3. Verifique se o banco foi criado corretamente:
   ```sql
   \l
   ```

## 📂 Estrutura do Projeto

O projeto está organizado da seguinte forma:

- `model`: Contém as classes de modelo `Livro` e `Autor` que representam as entidades da aplicação.
- `repository`: Contém os repositórios `LivroRepository` e `AutorRepository` para interação com o banco de dados.
- `service`: Contém os serviços `ConsumoApi`, `ConverteDados` e `LivroResposta` para gerenciar a comunicação com a API externa e conversão de dados.
- `principal`: Contém a classe `Principal`, que gerencia a lógica principal do menu interativo e as operações com o usuário.

## 🚀 Como Executar

### Pré-requisitos

- JDK 17 ou superior instalado.
- Maven 3.6+ instalado.
- PostgreSQL instalado e configurado.
- Banco de dados `livros` criado conforme instruções acima.

### Passos para execução

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/falapericles/projeto_literalura.git
   cd projeto_literalura
   ```

2. **Compile o projeto:**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Interaja com a aplicação:**
   - O menu interativo será exibido no console, permitindo executar as funcionalidades listadas acima.

## 🔗 Endpoints de Referência (API Gutendex)

A aplicação utiliza a seguinte URL base para buscar dados dos livros:

```
https://gutendex.com/books/
```

### 🔍 Exemplo de Uso da API

A pesquisa por um autor ou título específico é realizada utilizando o parâmetro `search`. Por exemplo:

```
https://gutendex.com/books/?search=Jane+Austen
```

## 🤝 Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`).
4. Faça o push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## 📝 Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
