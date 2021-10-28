From openjdk:8
EXPOSE 8084
ADD /target/GestionContact.jar GestionContact.jar
ENTRYPOINT ["java", "-jar", "/GestionContact.jar"]