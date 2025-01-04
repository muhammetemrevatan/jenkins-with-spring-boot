pipeline {

    agent any

    

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

    }

    

    post {

        always {

            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'

        }

    }

} 
