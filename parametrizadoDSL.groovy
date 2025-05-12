job('ejemplo-2-job-DSL') {
  description ('JOB 2 DE EJEMPLO PARA EL CURSO DE JENKINS')
  scm {
    git('https://github.com/lllanquiman/jenkins.job.parametrizado.git', 'main') { node ->
    node / gitConfigName('lllanquiman')
    node / gitConfigEmail('luciano.llanquiman@gmail.com')  
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Luciano', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  triggers {
    cron('H/7 * * * *')
  }
  steps {
    shell("bash jobscript.sh")
  }
  publishers {
    mailer('luciano.llanquiman@gmail.com', true, true)
    slackNotifier {
      notifyAborted(true)
      notifyEveryFailure(true)
      notifyNotBuilt(false)
      notifyUnstable(false)
      notifyBackToNormal(true)
      notifySuccess(false)
      notifyRepeatedFailure(false)
      startNotification(false)
      includeTestSummary(false)
      includeCustomMessage(false)
      customMessage(null)
      sendAs(null)
      commitInfoChoice('NONE')
      teamDomain(null)
      authToken(null)
    }
  }
}
