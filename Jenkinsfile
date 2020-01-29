node {
   // This is to demo github action	
   def sonarUrl = 'sonar.host.url=http://localhost:9000'
   stage('SCM Checkout'){
                   sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
   }
   
   stage('Sonar Publish'){
	   withCredentials([string(credentialsId: 'SonarQube', variable: 'sonarToken')]) {
        def sonarToken = "sonar.login=${b011d57fcf07add059b6c731ed68022160a85b5b}"
        sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D${sonarUrl}  -D${sonarToken}"
	 }
      
   }
}
