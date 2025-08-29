# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia a pasta onde está o pom.xml (demo/demo)
COPY demo/demo/ .

# Compila a aplicação sem rodar os testes
RUN mvn -B -DskipTests clean package

# Etapa 2: Runtime (somente o jar final)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o jar gerado do build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
