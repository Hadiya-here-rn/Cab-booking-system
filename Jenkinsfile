pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat '"C:\\Apache\\Maven\\apache-maven-3.9.14\\bin\\mvn.cmd" clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t cab-app .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker run -d -p 8092:8092 cab-app'
            }
        }
    }
}