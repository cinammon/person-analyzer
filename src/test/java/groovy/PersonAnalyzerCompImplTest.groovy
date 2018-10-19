package groovy

import db_task.Person
import db_task.service.PersonAnalyzerService
import spock.lang.Specification
import spock.lang.Subject

class PersonAnalyzerCompImplTest extends Specification {

    @Subject
    PersonAnalyzerService service

    def setup() { service = new PersonAnalyzerService() }

    def "given person full info return correct statement about him/her"() {
        given:
            Person person = new Person()
            person.setName("Mike")
            person.setAge(26)
            person.setCarsNo(2)
        and:
            String expectedStatement = "User Mike, who is 26 years old has 2 cars."
        when:
            String result = service.getPersonInfo(person)
        then:
            result == expectedStatement
    }

    def "given person info without car no return correct statement about him/her"() {
        given:
            Person person = new Person()
            person.setName("John")
            person.setAge(30)
        and:
            String expectedStatement = "User John, who is 30 years old has no cars."
        when:
            String result = service.getPersonInfo(person)
        then:
            result == expectedStatement
    }
}