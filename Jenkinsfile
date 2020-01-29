pipeline {
    agent any
       def sonarUrl = 'sonar.host.url=http://localhost:9000'
    stages {
        stage('---clean---') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
            }
        }
       stage('Sonar Publish'){
	   withCredentials([string(credentialsId: 'SonarQube', variable: 'sonarToken')]) {
        def sonarToken = "sonar.login=${65a336fd0bed26d5cbc1cb6e51f8d7a817b2fd3c}"
        sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D${sonarUrl}  -D${sonarToken}"
	 }
      
   }

        stage('--test--') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml test"
            }
        }
        stage('--package--') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml package"
            } 
   }
  }
}
