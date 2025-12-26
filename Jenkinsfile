pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Vuthy-Tourn/springboot-maven-test.git'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t jenkins-spring-maven-pipeline .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop springboot-maven || true
                    docker rm springboot-maven || true

                    docker run -d -p 8081:8081 \
                        --name springboot-maven \
                        jenkins-spring-maven-pipeline
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Spring Boot Docker Build & Deploy Successful'
        }
        failure {
            echo '❌ Spring Boot Pipeline Failed'
        }
    }
}
