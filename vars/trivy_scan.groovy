def call(){
  sh "trivy fs ."
  echo "Trivy scan successfully"
}