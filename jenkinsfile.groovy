pipeline {
    agent any

    stages {
        stage("print") {
            steps {
                echo 'hello test'
            }
        }
        stage("build") {
            steps {
                bat 'mvn clean install'
            }
        }
        stage("Test") {
            steps {
                echo 'Finish'
            }
        }
        stage("Build Docker File") {
            steps {
                bat 'docker build -t docker-demo .'
            }
        }
    }
}
