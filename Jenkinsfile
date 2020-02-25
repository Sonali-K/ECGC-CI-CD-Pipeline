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
     git credentialsId: '015761f8-6be8-4c93-84f2-b75049f78c1a', url: 'http://10.212.0.206:81/Sonali/ECGC-CI-CD-Angular-Spring-Boot-1'     
     sh 'docker build -t sdkanse/spring-boot-demo.war:1.0SNAPSHOT .'
   }
                
}


