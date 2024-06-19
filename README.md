# Iniflex

Este é um exemplo de aplicação Java (Versão 22) que pode ser executada dentro de um contêiner Docker.

## Pré-requisitos

- Java 22
- Ou
- [Docker](https://www.docker.com/get-started) instalado na máquina local.

## Como Executar

### Passo 1: Construir a Aplicação

Clone este repositório e navegue até o diretório do projeto:

```sh
git clone https://github.com/LuizVictor/iniflex.git
cd iniflex
```

### Passo 2: Construir a Imagem Docker

Execute o comando abaixo para construir a imagem Docker:

```sh
docker-compose up --build
```

### Parar e Remover o Contêiner

Para parar o contêiner, pressione `Ctrl + C` no terminal onde o docker-compose up está sendo executado.

Para remover o contêiner, execute o seguinte comando:


```sh
docker-compose down
```
