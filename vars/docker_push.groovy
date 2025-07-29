def call(String project, String imageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
    sh "docker login -u ${dockerHubUser} ${dockerHubPass} --password-stdin"
  }
  sh "docker push ${dockerHubUser}/${project}:${imageTag}"
  echo "Pushed to DockerHub"
}
