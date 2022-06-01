FROM openjdk:11
COPY ./build/libs/vendas-api-0.0.1-SNAPSHOT.jar vendas-api-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","vendas-api-0.0.1-SNAPSHOT.jar"]