pipeline {
    agent any

        parameters {
        string(
            name: 'MIN_ORDER_AMOUNT',
            defaultValue: '500',
            description: 'Минимальная сумма заказа'
        )
    }

    stages {
        stage('Build') {
            steps {
                bat '"D:\\IntelliJ IDEA 2026.2.3\\plugins\\maven-plugin\\lib\\maven3\\bin\\mvn.cmd" compile'
            }
        }

        stage('Test') {
            steps {
                bat '"D:\\IntelliJ IDEA 2026.2.3\\plugins\\maven-plugin\\lib\\maven3\\bin\\mvn.cmd" test'
            }
        }

        stage('Package') {
            steps {
                bat '"D:\\IntelliJ IDEA 2026.2.3\\plugins\\maven-plugin\\lib\\maven3\\bin\\mvn.cmd" package -DskipTests'
            }
        }

         stage('Show Parameter') {
            steps {
                echo "Минимальная сумма заказа: ${params.MIN_ORDER_AMOUNT}"
            }
        }
    }
}