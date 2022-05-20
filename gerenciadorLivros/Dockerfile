FROM debrum/ubuntu-jdk-mvn
RUN mkdir java-api-livros
COPY . java-api-livros
RUN cd java-api-livros && mvn clean package
RUN cp java-api-livros/target/*jar /app.jar
RUN rm -rf java-api-livros
ENTRYPOINT ["java", "-jar", "/app.jar"]