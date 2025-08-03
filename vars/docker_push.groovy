def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
      echo "Docker login successfully"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
  echo "Docker push successfully"
}