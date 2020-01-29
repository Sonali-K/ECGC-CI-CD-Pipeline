pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
            }
        }
       stage('Sonarqube') {
    environment {
        scannerHome = tool 'SonarQubeScanner'
    }    steps {
        withSonarQubeEnv('SonarQube') {
            sh "${mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml clean install sonar:sonar}/bin/sonar-scanner"
        }        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
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
