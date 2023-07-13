# API de Pets 

Uma API que permite gerenciar pets.

## Rotas

- Listar todos os pets: `GET /pets`
- Obter um pet por id: `GET /pets/id`
- Cadastrar um novo pet: `POST /pets`
>  ```
>    // body
>    {
>      "name": string,
>      "breed": string,
>      "birthDate": int,
>      "vaccinated": boolean,
>      "procedures": List<String>
>    }
>    ```
- Atualizar um pet existente: `PUT /pets/id`
>  ```
>    // body
>    {
>      "name": string,
>      "breed": string,
>      "birthDate": int,
>      "vaccinated": boolean,
>      "procedures": List<String>
>    }
>    ```
- Excluir um pet: `DELETE /pets/id`

## IMPORTANTE
- No arquivo application.properties o caminho do banco de dados deve ser informado da seguinte forma:

  spring.data.mongodb.uri = Url do MongoDB

Não está informado a url do meu banco de dados por questões de segurança.
