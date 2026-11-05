API Biblioteca

API REST para gerenciamento de livros de uma biblioteca, desenvolvida com Spring Boot.
 👤 Autor- 
Igor Castro de Carvalho Silva — desenvolvedor único do projeto
## 📚 Sobre o projeto
O **api-biblioteca** é uma API REST que permite cadastrar livros e consultá-los (listagem completa e busca por ID). O projeto segue a arquitetura em camadas (Controller → Service → Repository → Model) e foi desenvolvido para fins acadêmicos (IFPI).
## 🛠️ Tecnologias
- Java 21
- Spring Boot 4.1.2
- Spring Web
- Spring Data JPA (Jakarta Persistence)
- Maven
- Banco de dados: H2 (persistido em arquivo) com H2 Console
- IDE: IntelliJ IDEA
## 🗂️ Estrutura do projeto
br.edu.ifpi.api_biblioteca
├── controller
│   └── LivroController.java
├── model
│   └── Livro.java
├── repository
│   └── LivroRepository.java
└── service
    └── LivroService.java
``.
| Camada | Classe | Responsabilidade |
|---|---|---|
| Controller | `LivroController` | Expõe os endpoints REST em `/livros` |
| Service | `LivroService` | Regras de negócio; lança erro 404 quando o livro não existe |
| Repository | `LivroRepository` | Acesso ao banco via `JpaRepository<Livro, Long>` |
| Model | `Livro` | Entidade JPA mapeada para a tabela `livros` |
 📖 Modelo de dados
Tabela `livros`:
| Campo | Tipo | Descrição |
|---|---|---|
| `id` | `Long` | Identificador, gerado automaticamente |
| `titulo` | `String` | Título do livro |
| `autor` | `String` | Autor do livro |
| `anoPublicacao` | `Integer` | Ano de publicação |
| `disponivel` | `Boolean` | Indica se o livro está disponível para empréstimo |
 ▶️ Como executar
Pré-requisitos
- JDK 21 instalado
- Maven instalado (ou use o wrapper `mvnw`)
Passos
```bash
# 1. Clonar o repositório
git clone [https://github.com/TheGraveRaiser/api-biblioteca.git]
cd api-biblioteca

# 2. Executar a aplicação
./mvnw spring-boot:run
No Windows, use `mvnw.cmd spring-boot:run`.
A API ficará disponível em `http://localhost:8080`.
 🗄️ Banco de dados
O projeto usa o **H2** gravando em arquivo, então os dados são mantidos entre as execuções. O arquivo fica na pasta `./data/bibliotecadb` (criada na raiz do projeto ao rodar a aplicação). As tabelas são criadas e atualizadas automaticamente (`ddl-auto=update`) e as consultas SQL aparecem no console.

### Console do H2

Acesse `http://localhost:8080/h2-console` e use:

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:file:./data/bibliotecadb` |
| User Name | `sa` |
| Password | (vazio) |

## 🔗 Endpoints

Base: `/livros`

| Método | Rota | Descrição | Resposta |
|---|---|---|---|
| POST | `/livros` | Cadastra um novo livro | Livro criado (JSON) |
| GET | `/livros` | Lista todos os livros | Lista de livros (JSON) |
| GET | `/livros/{id}` | Busca um livro por ID | Livro (JSON) ou `404` |

### Exemplo: cadastrar livro
Requisição
```http
POST /livros
Content-Type: application/json
```

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "disponivel": true
}
```

**Resposta**

```json
{
  "id": 1,
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "anoPublicacao": 1899,
  "disponivel": true
}
```

### Exemplo: livro não encontrado

`GET /livros/99` retorna status **404 Not Found** com a mensagem `Livro não encontrado`.

```markdown
![Cadastro de livro](capturas/cadastro.png)
![Listagem de livros](capturas/listagem.png)
```
Projeto de uso acadêmico.
