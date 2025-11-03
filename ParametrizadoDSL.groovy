job('ejemplo2-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  scm{
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node -> 
      node / gitConfigName('DanielAquino2003')
      node / gitConfigEmail('aquinosantiagodani@gmail.com')
    }
  }
  parameters{
  	stringParam('nombre', defaultValue = 'Julian', description = "Parametro de cadena para el Job" )
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra', 'Marte'])
    booleanParam('agente', false)
  }
  triggers{
  	cron('H/7 * * * *')
  }
  steps{
  	shell("bash jobscript.sh")
  }
}
