node {

   // This is to demo github action	
   def sonarUrl = 'sonar.host.url=http://localhost:9000/projects'
    
   stage('SCM Checkout'){
                         sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
                         echo "Running Stage First"
                        }
   
   stage('SonarQube Analysis'){

	              withCredentials([string(credentialsId: 'c62b330d-9cc8-4cc7-ade4-faf3d1a33674', variable: 'sonarToken')]) 
                              {
                      def sonarToken = "sonar.login='b011d57fcf07add059b6c731ed68022160a85b5b'"
                      sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D${sonarUrl}  -D${sonarToken}"
	             }
      
                    }

   stage('TestNG Report') {
            
                  script {
                        sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml clean test"
                          }
                   step([$class : 'Publisher', reportFilenamePattern : 'spring_boot_demo/test-output/testng-results.xml'])   
                         }

    
   stage('Ansible') {
           
                script {
                     sh 'ansible-playbook tomcat.yml'
                    
                     }   
            
                  }
    

}
