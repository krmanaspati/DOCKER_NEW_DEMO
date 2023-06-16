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

        stage("Deploy Docker File") {
            steps {
                script{
                    withCredentials([string(credentialsId: 'DOCKER_HUB', variable: 'DOCKER_HUB_PWB')]) {
   bat ' docker login -u krmanaspati@gmail.com -p ${DOCKER_HUB_PWB}'
                        
}
                    bat 'docker push docker-demo'
                }
                    
            }
        }
    }
}
