#Dockerfile
FROM openjdk:21-ea-24-oracle

WORKDIR /app

#aqui debemos asegurarnos que el nombre dee nuestro jar coincida
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

#Ubicacion y nombre del Wallet descomprimido
COPY Wallet_S2EAZR8T9KFHQM3E /app/oracle_wallet/

#Puerto
EXPOSE 8080

CMD [ "java","jar","app.jar" ]