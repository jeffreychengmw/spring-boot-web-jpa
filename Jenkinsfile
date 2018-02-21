pipeline {
    agent any
    environment {
    	DISABLE_AUTH = 'true'
    	DB_ENGINE = 'sqlite'
    }
    stages {
        stage('build') {
            steps {
            	timeout(time: 30, unit: 'SECONDS') {
	                sh 'echo "Hello Jenkins @build"'
	                sh 'printenv'           
	            }
            }
        }
        stage('test') {
            steps {
            	timeout(time: 30, unit: 'SECONDS') {
	                sh 'echo "Hello Jenkins @test"'
	            }
            }
        }
        stage('deploy') {
            steps {
            	timeout(time: 30, unit: 'SECONDS') {
	                sh 'echo "Hello Jenkins @deploy"'
	            }
            }
        }
    }
}