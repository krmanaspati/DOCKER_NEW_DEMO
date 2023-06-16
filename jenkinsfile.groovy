pipeline {
    agent any

    stages {
        stage("build") {
            steps {
                echo 'hello test'
            }
        }
        stage("build") {
            steps {
                bat 'mvn clean build'
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