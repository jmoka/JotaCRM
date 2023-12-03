# JotaCRM
CRM Contábil e Controle de Clientes

# Tecnologias
    - Java
    - JavaEscript
    - HTML
    - CSS
    - Bootstrap
    - Mavem
    - Spring Boot
    - Apache Tomcat
    - PostMam
    - JPA
    - JSP
    - JDBC
    
# Roteiro de Construção

## 1) Criar o projeto:
    - https://start.spring.io/

### config:
        - Mavem
        - 3.2.0
        - jar
        - 17

### Dependencies:
        - Spring Web
        - Thymeleaf
        - WebSocket
        
## 2) Banco de dados
        - Mysql
        - MySQLWorkbench
        - DbDesigner 4

## 3) Bibliotecas
        - mysql-connector-j-8.2.0

# Checklist:
## Entidades)
        - Implementes Interface
        - Extendes Class Abstract implements Interfaces
        - Basic attributes
        - Associations (instantiate collections)
        - Constructors
        - Getters & Setters (collections: only get)
        - hashCode & equals
        - toString
        - Serializable
## Recuperação Banco de Dados)
### Statement
        - Em Java, a interface Statement faz parte da API JDBC (Java Database Connectivity) e é usada para < executar instruções SQL > em um banco de dados. Três principais métodos da interface Statement incluem:

#### 1º) executeQuery (String sql):
         Executa uma instrução SQL que < retorna um conjunto de resultados> , como em consultas SELECT.

#### 1º)executeUpdate(String sql): Executa uma instrução SQL que pode alterar dados no banco de dados, como em instruções INSERT, UPDATE ou DELETE.

execute(String sql): Executa qualquer tipo de instrução SQL, seja uma consulta, uma atualização ou outros tipos de comandos.
# Entidades
## Nivel)
        - idNivel
        - nomeNivel
