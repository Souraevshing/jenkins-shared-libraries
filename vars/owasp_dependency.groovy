def call(){
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
  echo "OWASP dependency check successfully"
}