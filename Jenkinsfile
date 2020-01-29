pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
            }
        }
      stage('OWASP ZAP') {
              agent any
              steps {
                sh '''
                 export ARCHERY_HOST=http://10.212.8.121:8000
                     bash /home/cdac-kharghar2/Downloads/Softwares/ZAP/ZAP_2.7.0/zap.sh
                  '''
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
