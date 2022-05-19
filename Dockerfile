# define base docker image
FROM openjdk:11
LABEL maintainer="preznyak"
ADD target/palindrome-0.0.1-SNAPSHOT.jar palindrome.jar
ENTRYPOINT ["java", "-jar", "palindrome.jar"]
