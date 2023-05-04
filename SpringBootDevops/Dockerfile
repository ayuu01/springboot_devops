FROM openjdk:11 as build

EXPOSE 8080

ADD target/execJar.jar execJar.jar

ENTRYPOINT ["java", "-jar", "execJar.jar"]