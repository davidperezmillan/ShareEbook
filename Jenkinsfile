pipeline {
  agent any
  environment {
    name = 'davidperez01/sharebook'
  }
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/davidperezmillan/ShareEbook.git', branch: 'main', changelog: true)
      }
      post {
	    success {
	      slackSend(color: 'good', channel:'ShareEbook', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Recuperamos correctamente")
	    }
	    failure {
	      slackSend(color: 'danger', channel:'ShareEbook', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Hubo un problema con el Git")
	    }
	  }
    }
    stage('Clean') {
      agent any
      steps {
        echo "Nombre del proyecto: ${name}"
        echo 'Clean mvn'
        sh 'mvn clean -DskipTests=true'
      }
    }
    stage('Test') {
      agent any
      steps {
        echo 'Test Project'
        sh 'mvn test'
      }
    }
    stage('Build & Docker') {
      agent any
      steps {
        echo 'mvn Build'
        sh 'mvn install -DskipTests=true'
        echo 'Docker Imagen'
        sh "docker image build -t ${name} ."
      }
    }
    stage('Docker Register') {
      agent any
      environment {
        registry = "${name}"
        registryCredential = 'dockerhub'
      }
      steps {
        echo 'Register Docker'
        echo "registry: ${registry}"
      }
    }
  }
  post {
    success {
      slackSend(color: 'good', channel:'ShareEbook', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Funcionó correctamente")
    }
    failure {
      slackSend(color: 'danger', channel:'ShareEbook', message: "${env.JOB_NAME} - ${env.BUILD_DISPLAY_NAME} - Hubo un problema con el deploy")
    }
  }
}
