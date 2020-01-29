pipeline {
    agent any
    stages {
        stage('---clean---') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
            }
        }
      stage('Setup') {
            steps {
                script {
                    startZap(host: "localhost", port: 5555, timeout:500, zapHome: "/home/cdac-kharghar2/Downloads/Softwares/ZAP/ZAP_2.7.0", sessionPath:"/somewhere/session.session", allowedHosts:['github.com']) // Start ZAP at /opt/zaproxy/zap.sh, allowing scans on github.com (if allowedHosts is not provided, any local addresses will be used
                }
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    sh "mvn verify -Dhttp.proxyHost=localhost -Dhttp.proxyPort=5555 -Dhttps.proxyHost=localhost -Dhttps.proxyPort=5555" // Proxy tests through ZAP
                }
            }
        }
    }
    post {
        always {
            script {
                archiveZap(failAllAlerts: 1, failHighAlerts: 0, failMediumAlerts: 0, failLowAlerts: 0, falsePositivesFilePath: "zapFalsePositives.json")
            }
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
