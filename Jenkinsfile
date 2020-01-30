pipeline {
    agent any
     options
            { 
              timestamps()  
            }
    
    stages { 
        stage('Ansible') {
            steps {
                script {
                   sh "sudo ansible-playbook tomcat.yml"
                    
                }   
            }
        }
       
    }
}


