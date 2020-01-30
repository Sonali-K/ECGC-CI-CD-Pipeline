pipeline {
    agent any
     options
            { 
              timestamps()  
            }
    
    stages { 
        stage('Setup') {
            steps {
                script {
                   sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml clean test"
                    
                }
               step([$class : 'Publisher', reportFilenamePattern : 'spring_boot_demo/test-output/testng-results.xml'])
                  
               
            }
        }
       
    }
}


