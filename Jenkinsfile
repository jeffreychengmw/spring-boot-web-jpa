pipeline {
    agent any
    stages {
        stage('build') {
            steps {
            	timeout(time: 30, unit: 'SECONDS') {
	                sh 'echo "Hello Jenkins"'
	                sh '''
	                	echo "Multi-line shell steps works too"
	                	ls -lah
	                '''
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