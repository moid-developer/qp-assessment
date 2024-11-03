FROM openjdk:21
EXPOSE 8080
ARG JAR_FILE=target/grocery-store-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} GroceryStore.jar
ENTRYPOINT ["java","-jar","/GroceryStore.jar"]