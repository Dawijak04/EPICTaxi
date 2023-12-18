FROM openjdk:21
WORKDIR /opt
COPY EPICTaxi/target/classes/org/example/*.class /opt/app.jar
CMD ["java","-jar","app.jar"]
