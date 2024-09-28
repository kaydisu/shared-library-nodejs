#!/user/bin/env groovy

def call() {
    sh "npm install"
    sh "npm run test"
}