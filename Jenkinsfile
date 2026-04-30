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
        bat 'docker rm -f cab-container || true'
        bat 'docker run -d -p 8092:8092 --name cab-container cab-app'
    }
}
    }
}