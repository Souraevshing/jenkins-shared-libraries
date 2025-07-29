def call(String project, String imageTag, String dockerHubUser){
  withCredentials([usernamePassword(
    credentialsId: 'dockerHubCred',
    passwordVariable: 'dockerHubPass',
    usernameVariable: 'dockerHubUser'
  )]) {
    sh '''
      echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
    '''
    sh """
      docker image tag ${project}:${imageTag} ${dockerHubUser}/${project}:${imageTag}
      docker push ${dockerHubUser}/${project}:${imageTag}
    """
    echo "Pushed to DockerHub"
  }
}
