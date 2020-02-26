node {

// This is to demo github action	
 def sonarUrl = 'sonar.host.url=http://localhost:9000/projects' 
  stage('SCM Checkout-Compile')
     {
    sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
      echo "Running Stage First"
         input 'Are you sure?'
          }
   
stage('SonarQube Analysis'){

       withCredentials([string(credentialsId: 'c62b330d-9cc8-4cc7-ade4-faf3d1a33674', variable: 'sonarToken')]) 
         {
           def sonarToken = "sonar.login='b011d57fcf07add059b6c731ed68022160a85b5b'"
             sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D  ${sonarUrl}  -D${sonarToken}"
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
                   sh 'ansible-playbook tomcat.yml'
                     }   
                  }
   
  

   stage('Build Docker Image'){
  git credentialsId: 'eb857953-4899-4983-928e-450aa25606d5', url: 'http://10.212.0.206:81/Sonali/ECGC-CI-CD-Angular-Spring-Boot-1'
     sh 'docker build -t sdkanse/spring-boot-demo.war:2.0SNAPSHOT .'
   }
      stage('Push Docker Image'){
    withCredentials([string(credentialsId: 'DockerHubID', variable: 'DockerHub')]) {
    // some block
             sh "docker login -u sdkanse -p ${DockerHub}"
}
     sh 'docker push sdkanse/spring-boot-demo.war:2.0SNAPSHOT'
   }           
}


