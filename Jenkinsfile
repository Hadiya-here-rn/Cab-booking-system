pipeline {
    agent any

    stages {

        stage('Build (Maven in Docker)') {
            steps {
                sh '''
                docker run --rm \
                -v /var/jenkins_home/workspace/Cab-booking-pipeline:/app \
                -w /app \
                maven:3.9.9-eclipse-temurin-17 \
                mvn clean package
                '''
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t cab-app .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run -d -p 8081:8090 cab-app'
            }
        }
    }
}