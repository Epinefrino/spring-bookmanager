# spring-bookmanager
Projetinho em spring de um gestor de livros e autores. 

É possível cadastrar autores, livros e assunto usando os endpoints. No entanto as associações entre eles também precisam ser cadastradas por meio de um endepoint diferente. 

Para ver a lista de endpoints acesse http://localhost:8080/swagger-ui.html

Para ver os elementos em um formato mais próximo do RESTful acesse http://localhost:8080/ e a partir daí vc terá acesso aos endpoints criados pela extensão HATEOAS do Spring Data. Para adicionar uma associação é necessário enviar um PUT para o link da associação que o HATEOAS informa, um exemplo é "http://localhost:8080/livroes/3/autores"

O PUT deve conter o(s) link(s)  do(s) autor(es) que se deseja associar a esse livro. Como no exemplo abaixo:
curl -1 -X PUT -H "Content-Type:text/uri-list" -d 'http://localhost:8080/autors/1' http://localhost:8080/livroes/3/autores

» Para Rodar Esta Aplicação:
Você deve importá-la para sua IDE favorita, por ser um projeto maven as dependências serão obtidas sem necessidade de configuração adicional. Também é possível executar esta aplicação utilizando maven na linha de comando.
