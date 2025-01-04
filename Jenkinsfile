pipeline {
    agent any
    
    triggers {
        githubPush()
    }
    
    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn test'
                    } else {
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Build & Deploy') {
            steps {
                script {
                    if (isUnix()) {
                        sh '''
                            docker rm -f spring-app || true
                            docker build -t spring-app .
                            docker run -d --name spring-app -p 8081:8080 spring-app
                        '''
                    } else {
                        bat '''
                            docker rm -f spring-app || true
                            docker build -t spring-app .
                            docker run -d --name spring-app -p 8081:8080 spring-app
                        '''
                    }
                }
            }
        }
    }
    
    post {
        always {
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Pipeline başarıyla tamamlandı!'
        }
        failure {
            echo 'Pipeline başarısız oldu!'
        }
    }
} 
