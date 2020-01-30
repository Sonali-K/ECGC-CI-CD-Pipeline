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
                   sh "ansible-playbook tomcat.yml"
                    
                }   
            }
        }
       
    }
}


