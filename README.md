## Blog BeckEnd

## Technologies used

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Hibernate
- JSON
- POSTGRES
- JWT (Json Web Token)

1 - Executar o docker compose -- será criado o banco e adicionado os dados.

* Caso o docker composer não subir deve ser apagado a pasta pgdata

2 - Rodar o Script SQL no banco  
* localhost:5432/blog * user= postgres * password=framework

INSERT INTO public.tb_usuario VALUES (68, 'Admin@dev', '$2a$10$EoVHycYU/6r.7LhQIRVIouPiNqXodxtO45QAGHQcMIa4C1pqivh1O');

3 - executar a aplicação

4 - Recuperar o token:
acessa localhost:9005/login passando o json conforme abaixo

{
"login":"Admin@dev",
"password":"Dev@2022"
}

Exemplo:
eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBZG1pbkBkZXYiLCJleHAiOjE2NDEwOTIzNjZ9.rmDbWR1YPYN_slXkrUUHi9AN2HtKvp9KkJkuv-1d8GEWjOXCK1PaoMi0tFRPrphRmWmCd7Arjn2kUBsbX65y2g

5 - Importar o arquivo de Blog.postman_collection.json do postman ou Insominia para uso do endpoints.

***
Executar o save de autor, em segunda pegar o json gerado e adicionar na quesição de save da postagem.
***

### Obs.

Devido a entregas não foi possível os itens de carregar imagens, frontEnd e demais estruturas do sistema. 











