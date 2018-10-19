package db_task.service;

import db_task.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonAnalyzerService {

    private final String STATEMENT_WITH_CARS = "User %s, who is %d years old has %d cars.";
    private final String STATEMENT_NO_CARS = "User %s, who is %d years old has no cars.";

    public String getPersonInfo(Person person) {
        String result;

        if (person.getCarsNo() == null) {
            result = String.format(STATEMENT_NO_CARS, person.getName(), person.getAge());
        } else result = String.format(STATEMENT_WITH_CARS, person.getName(), person.getAge(), person.getCarsNo());

        return result;
    }
}
