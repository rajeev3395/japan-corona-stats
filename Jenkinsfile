pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh './gradlew clean build -x test'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh './gradlew -PenableChecks test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
