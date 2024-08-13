pipeline {
    agent any
    tools{
        maven 'maven 3.9.8'
        }
    triggers {
        pollSCM 'H/2 * * * *'
     }
    options {
       timestamps()
     }

stages {
        stage('Git Checkout') {
            steps {
                echo 'Source Code Management: Getting source code from GitHub to Jenkins'
                git branch: 'development', credentialsId: '139135dd-ab17-4643-b883-019e5f23d5e0', url: 'https://github.com/Subbu2025/HospitalManagement.git'
            }
        }
        stage('Maven Build') {
            steps {
                echo 'Building the Artifact using Maven'
                sh "mvn clean package"
            }
        }
        stage('SonarQube QA') {
            steps {
                echo 'Generating the Source Code Analysis Report using SonarQube'
                sh "mvn sonar:sonar"
            }
        }
        stage('Load Artifact into Nexus') {
            steps {
                echo 'Loading Artifacts into Nexus Repositories'
                sh "mvn deploy"
            }
        }
      stage('deploy-tomcat') {
            steps {
               sshagent(['ee4252c2-ee46-4955-a5ef-62629bf4f972'])
             {
                sh "scp -o StrictHostKeyChecking=no target/HospitalManagement.war ec2-user@3.83.33.91:/opt/tomcat/webapps/"
            }
        }
      }
    }
  post {
  success {
    notifyBuild(currentBuild.result)
  }
  failure {
   notifyBuild(currentBuild.result)
  }
}
  } 
  
  def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESS'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }
  // Send notifications
  slackSend (color: colorCode, message: summary)
}
  
