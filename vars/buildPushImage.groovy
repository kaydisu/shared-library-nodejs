#!/user/bin/env groovy

def call() {
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t ebony9ja/nodes-twn-repo:${IMAGE_NAME} ./app"
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push ebony9ja/nodes-twn-repo:${IMAGE_NAME}"
    }
}