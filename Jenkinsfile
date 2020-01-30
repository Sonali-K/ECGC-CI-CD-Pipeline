
node {
  wrap([$class: 'Xvfb']) {
            stage('OWASP ZAP') {
              agent any
              steps {
                     {
                sh '''
                 export ARCHERY_HOST=http://10.212.8.121:8000
                     bash /home/cdac-kharghar2/Downloads/Softwares/ZAP/ZAP_2.7.0/zap.sh
                  '''
              }
            }
          }
        }
    }
 

