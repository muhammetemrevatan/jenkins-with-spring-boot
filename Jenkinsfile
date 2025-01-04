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
        
        stage('Build & Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean install'
                    } else {
                        bat 'mvn clean install'
                    }
                }
            }
        }

        stage('Test Coverage') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn verify'
                    } else {
                        bat 'mvn verify'
                    }
                }
            }
            post {
                success {
                    jacoco(
                        execPattern: 'target/*.exec',
                        classPattern: 'target/classes',
                        sourcePattern: 'src/main/java',
                        exclusionPattern: 'src/test*'
                    )
                }
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker build -t jenkins-demo .'
                    } else {
                        bat 'docker build -t jenkins-demo .'
                    }
                }
            }
        }

        stage('Docker Deploy') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker-compose up -d app'
                    } else {
                        bat 'docker-compose up -d app'
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
