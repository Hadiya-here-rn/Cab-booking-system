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
        bat 'docker ps -q > container.txt'
        bat 'for /f %i in (container.txt) do docker stop %i'
        bat 'docker ps -aq > all.txt'
        bat 'for /f %i in (all.txt) do docker rm %i'
        bat 'docker run -d -p 8095:8092 --name cab-container cab-app'
    }
}
    }
}