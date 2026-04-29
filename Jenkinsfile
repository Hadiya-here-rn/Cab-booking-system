pipeline {
    agent any

    stages {

        stage('Debug Workspace') {
            steps {
                sh 'ls -R $WORKSPACE'
            }
        }

        stage('Build (Maven in Docker)') {
            steps {
                sh '''
                docker run --rm ^
                -v C:/Users/Hadiya/Cab-booking-system:/workspace ^
                -w /workspace ^
                maven:3.9.9-eclipse-temurin-17 ^
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
                sh 'docker run -d -p 8081:8080 cab-app'
            }
        }
    }
}
