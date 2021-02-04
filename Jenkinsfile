pipeline {
  agent any
  stages {
    stage('Clone') {
      steps {
        git(url: 'https://github.com/davidperezmillan/ShareEbook.git', branch: 'main', changelog: true)
      }
    }

  }
}