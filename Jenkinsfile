pipeline {
    agent any
    stages { 
        stage('Setup') {
            steps {
                script {
                    (host: 10.212, port: 8080, timeout:500, zapHome: "/home/cdac-kharghar2/Downloads/Softwares/ZAP/ZAP_2.7.0/zap.sh", sessionPath:"/somewhere/session.session", allowedHosts:['github.com']) // Start ZAP at /opt/zaproxy/zap.sh, allowing scans on github.com
                }
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    sh "mvn verify -Dhttp.proxyHost=10.212.8.121 -Dhttp.proxyPort=8080 -Dhttps.proxyHost=10.212.8.121 -Dhttps.proxyPort=8080" // Proxy tests through ZAP
                }
            }
        }
    }
   
}
