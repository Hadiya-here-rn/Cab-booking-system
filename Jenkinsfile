pipeline {
    agent any

    stages {

        stage('Debug Workspace') {
            steps {
                sh 'ls -l /var/jenkins_home/workspace/Cab-booking-pipeline'
            }
        }

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

    }
}