import grails.util.Metadata

grails.project.class.dir = 'target/classes'
grails.project.test.class.dir = 'target/test-classes'
grails.project.test.reports.dir	= 'target/test-reports'
grails.project.docs.output.dir = 'docs' // for the gh-pages branch

grails.project.dependency.resolution = {

	inherits('global')

	log 'warn'

	repositories {        
		grailsPlugins()
		grailsHome()
		grailsCentral()
		ebr() // SpringSource  http://www.springsource.com/repository

		mavenCentral()
	}

	dependencies {
		runtime('org.springframework.security:org.springframework.security.ldap:3.0.4.RELEASE') {
//			transitive = false
			excludes 'spring-security-core', 'spring-web', 'spring-jdbc', 'spring-test',
				 'commons-codec', 'hsqldb', 'servlet-api', 'junit', 'mockito-core', 'jmock-junit4'
		}
		runtime('org.springframework.ldap:org.springframework.ldap:1.3.0.RELEASE') {
//			transitive = false
			excludes 'spring-security-core', 'spring-web', 'spring-jdbc', 'spring-test',
				 'commons-codec', 'hsqldb', 'servlet-api', 'junit', 'mockito-core', 'jmock-junit4'
		}
	}
	plugins {

		if (Metadata.current.getGrailsVersion()[0] != '1') {
			build(":hibernate:$grailsVersion") {
				export = false
				excludes 'dom4j'
			}
		}

		// hackish using 'provided' but 'build' doesn't put it in the pom
		provided ':webxml:1.4.1'
	}
}
