node {
   // This is to demo github action	
   def sonarUrl = 'sonar.host.url=http://localhost:9000/projects'
   stage('SCM Checkout'){
                   sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
   }
   
   stage('Sonar Publish'){
	   withCredentials([string(credentialsId: 'c62b330d-9cc8-4cc7-ade4-faf3d1a33674', variable: 'sonarToken')]) {
        def sonarToken = "sonar.login='b011d57fcf07add059b6c731ed68022160a85b5b'"
        sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml sonar:sonar -D${sonarUrl}  -D${sonarToken}"
	 }
      
   }
}
