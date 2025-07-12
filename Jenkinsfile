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
			when {
				expression { params.ENVIRONMENT == 'dev' }
			}
			steps {
				sh "mvn clean install -Pdev"
			}
		}

		stage('Build QA') {
			when {
				expression { params.ENVIRONMENT == 'qa' }
			}
			steps {
				sh "mvn clean install -Pqa"
			}
		}

		stage('Build UAT') {
			when {
				expression { params.ENVIRONMENT == 'uat' }
			}
			steps {
				sh "mvn clean install -Puat"
			}
		}

		stage('Build Prod') {
			when {
				expression { params.ENVIRONMENT == 'prod' }
			}
			steps {
				sh "mvn clean install -Pprod"
			}
		}
	}
}
