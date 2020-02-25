node {

// This is to demo github action	
 def sonarUrl = 'sonar.host.url=http://localhost:9000/projects' 
  stage('SCM Checkout-Compile')
     {
    sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
      echo "Running Stage First"
         input 'Are you sure?'
          }
   
   stage('Build Docker Image'){
     sh 'docker build -t sdkanse/spring-boot-demo.war:1.0SNAPSHOT .'
   }
                
}


