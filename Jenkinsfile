pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
            }
        }
        stage('build & SonarQube analysis') {
           steps {
              withSonarQubeEnv('c62b330d-9cc8-4cc7-ade4-faf3d1a33674') {
                 sh 'mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml clean install sonar:sonar'
              }
          }
      }

      stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
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
