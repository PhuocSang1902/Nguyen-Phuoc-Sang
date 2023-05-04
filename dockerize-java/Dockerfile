FROM openjdk:8-alpine

WORKDIR /app

COPY . /app/

RUN javac /src/com/company/Main.java

ENTRYPOINT ["java", "Main"]