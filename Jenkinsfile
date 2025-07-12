pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build DEV') {
            steps {
                sh "mvn clean install -Pdev"
            }
        }

        stage('Build QA') {
            steps {
                sh "mvn clean install -Pqa"
            }
        }

        stage('Build UAT') {
            steps {
                sh "mvn clean install -Puat"
            }
        }

        stage('Build PROD') {
            steps {
                sh "mvn clean install -Pprod"
            }
        }
    }
}