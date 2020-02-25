FROM tomcat:8.5.16-jre8-alpine
COPY /home/cdac-kharghar2/Downloads/Softwares/TOMCAT-SERVER/apache-tomcat-8.5.45/webapps/spring_boot_demo-0.0.1-SNAPSHOT.war demo.war
EXPOSE 3333
ENTRYPOINT ["java","-jar","demo.war"]
                                                                                                                                             
          
