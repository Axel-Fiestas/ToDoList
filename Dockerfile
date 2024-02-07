FROM openjdk:17-jdk-alpine
COPY ./target/ToDoList-0.0.1-SNAPSHOT.jar /
RUN sh -c 'touch ToDoList-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","/ToDoList-0.0.1-SNAPSHOT.jar"]
RUN chmod +x /ToDoList-0.0.1-SNAPSHOT.jar