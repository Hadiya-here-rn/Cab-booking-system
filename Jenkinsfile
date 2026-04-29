pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git 'YOUR_REPO_LINK'
            }
        }

        stage('Build (Maven in Docker)') {
            steps {
                sh '''
                docker run --rm \
                -v $PWD:/app \
                -w /app \
                maven:3.9.9-eclipse-temurin-17 \
                mvn clean package
                '''
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t Cab-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run -d -p 8081:8080 Cab-app'
            }
        }
    }
}