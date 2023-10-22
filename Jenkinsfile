pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'master' , 
                url : 'https://github.com/HassenBenadel/-smartAquaWatcher-Api-.git';
            }
        }

        stage('Nettoyage Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                
            }
        }

         stage('Exécution des tests') {
            steps {
                sh "mvn test "  // Run JUnit tests
            }      
        }
   
        stage('SonarQube') {
            steps {
                // Provide SonarQube authentication using the provided token
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                }
            }
        }
    }
}
