FROM tomcat:8.5.16-jre8-alpine
COPY ./spring_boot_demo.war demo1.war
EXPOSE 8089
ENTRYPOINT ["java","-jar","demo1.war"]



