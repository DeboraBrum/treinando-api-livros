
docker rm cont-api-livros
docker pull debrum/api-livros
docker run -it -e USER -e PASSWORD -e DATABASE_URL -p 8080:8080 --name cont-api-livros debrum/api-livros
docker logs api-livros -f
