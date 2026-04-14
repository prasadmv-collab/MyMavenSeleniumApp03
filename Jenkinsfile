pipeline {
    agent any  // Use any available agent

    tools {
        maven 'Maven'  // Ensure this matches the name configured in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/prasadmv-collab/MyMavenSeleniumApp03.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'  // Run Maven build
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'  // Run unit tests
            }
        }
        
stage('Check Target Folder') {
    steps {
        sh 'ls -l target'
    }
}
        
        
       
       stage('Run Application') {
    steps {
        sh 'java -jar target/MyMavenSeleniumApp01-1.0-SNAPSHOT.jar'
    }
}
        

        
    }

    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
