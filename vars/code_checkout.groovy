def call(String GitUrl, String GitBranch){
  git url: "${GitUrl}", branch: "${GitBranch}"
  echo "Code checkout successfully"
}