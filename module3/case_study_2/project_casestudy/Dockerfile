#FROM gradle:7.6-jdk8
#
#WORKDIR /project
#
#COPY . /project
#
#RUN gradle build
#
#CMD["java","-jar","build/libs/project_casestudy_2-1.0-SNAPSHOT.jar"]
FROM tomcat:8.0-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./build/libs/project_casestudy_2-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]