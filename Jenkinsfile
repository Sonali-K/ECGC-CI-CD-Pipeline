node {

// This is to demo github action	
 def sonarUrl = 'sonar.host.url=http://10.212.8.121:9000/sonarqube' 
  stage('SCM Checkout-Compile')
     {
    sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
      echo "Running Stage First"
         input 'Are you sure?'
          }
   
stage('SonarQube Analysis'){

       withCredentials([string(credentialsId: 'SonarQubeUpdatedKey', variable: 'sonarqube1')]) 
         {
           def sonarToken = "sonar.login='a19987d4eb7d7420487c4772e70b34e4b5e136f6'"
             sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D  ${sonarUrl}  -D${sonarqube1}"
                  echo 'SonarQube Analysis'
                    input "Are you sure?"
	            }
                   }

         stage('TestNG Report') {
            
              script {
                   sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml clean test"
                     echo 'TestNG Report'
                       input "Are you sure?"
                        }
                         step([$class : 'Publisher', reportFilenamePattern : 'spring_boot_demo/test-output/testng-results.xml'])   
                          }

    
              stage('Ansible') {
           
                 script {
            git credentialsId: 'eb857953-4899-4983-928e-450aa25606d5', url: 'http://10.212.0.206:81/Sonali/ECGC-CI-CD-Angular-Spring-Boot-1'
                   sh 'ansible-playbook tomcat.yml'
                   input "Are you sure?"
                     }   
                  }
   
        stage('Build Docker Image'){
            git credentialsId: 'eb857953-4899-4983-928e-450aa25606d5', url: 'http://10.212.0.206:81/Sonali/ECGC-CI-CD-Angular-Spring-Boot-1'
              sh 'docker build -t sdkanse/spring-boot-demo.war:2.0SNAPSHOT .'
                input "Are you sure?"
               }
       stage('Push Docker Image'){
           withCredentials([string(credentialsId: 'DockerHubID', variable: 'DockerHub')]) {
              // some block
             sh "docker login -u sdkanse -p ${DockerHub}"
              }
              sh 'docker push sdkanse/spring-boot-demo.war:2.0SNAPSHOT'
         }           
}


