pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Vuthy-Tourn/springboot-maven-test.git'
            }
        }

        stage('Build & Deploy') {
            steps {
                sh '''
                    docker-compose down
                    docker-compose build
                    docker-compose up -d
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Spring Boot + PostgreSQL deployed successfully'
        }
        failure {
            echo '❌ Pipeline failed'
        }
    }
}
