pipeline {
	agent any

	parameters {
		choice(
			name: 'ENVIRONMENT',
			choices: ['dev','qa', 'uat', 'prod'],
			description: 'Select the environment profile'
		)
	}

	stages {
		stage('Checkout') {
			steps {
				checkout scm
			}
		}
		stage('Build DEV') {
			 {
				expression { params.ENVIRONMENT == 'dev' }
			}
			steps {
				sh "mvn clean install -Pdev"
			}
		}

		stage('Build QA') {
			 {
				expression { params.ENVIRONMENT == 'qa' }
			}
			steps {
				sh "mvn clean install -Pqa"
			}
		}

		stage('Build UAT') {
			 {
				expression { params.ENVIRONMENT == 'uat' }
			}
			steps {
				sh "mvn clean install -Puat"
			}
		}

		stage('Build Prod') {
			 {
				expression { params.ENVIRONMENT == 'prod' }
			}
			steps {
				sh "mvn clean install -Pprod"
			}
		}
	}
}
