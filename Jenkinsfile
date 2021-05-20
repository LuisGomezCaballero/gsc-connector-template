pipeline {

  agent any

  stages {

    stage('Compile') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn' clean compile"
        }
      }
    }

    stage('Unit test') {
//      when {
//        expression {
//          false
//        }
//      }
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn' test"
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Integration test') {
//      when {
//        expression {
//          false
//        }
//      }
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn' verify -Dunit-tests.skip=true"
        }
      }
    }

    stage('Package') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn' package"
        }
      }
    }
    
    stage('Sonar') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn'  verify sonar:sonar -Dintegration-tests.skip=true -Dmaven.test.failure.ignore=true -Dsonar.host.url=http://172.18.0.3:9000"
        }
      }
    }

    stage('Deployment') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.8.1'
          sh "'${mvnHome}/bin/mvn' spring-boot:run > /dev/null"
        }
      }
    }
    
  }
}
