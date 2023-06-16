pipeline {
    agent any
environment {
    DOCKERHUB_CREDENTIALS = credentials('DOCKER_HUB')
  }
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
                echo '${DOCKERHUB_CREDENTIALS_PSW}'
            }
        }
        stage("Build Docker File") {
            steps {
                bat 'docker build -t docker-demo .'
            }
        }

        stage("Deploy Docker Login") {
            steps {
               bat 'echo ${DOCKERHUB_CREDENTIALS_PSW} | docker login -u ${DOCKERHUB_CREDENTIALS_USR} --password-stdin'     
            }
        }

        stage("Deploy Docker Push") {
            steps {
              bat 'docker push docker-demo'    
            }
        }
    }
}
