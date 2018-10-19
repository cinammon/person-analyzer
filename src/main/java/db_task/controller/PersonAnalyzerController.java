package db_task.controller;

import db_task.Person;
import db_task.service.PersonAnalyzerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(PersonAnalyzerController.ROOT_MAPPING)
public class PersonAnalyzerController {

    static final String ROOT_MAPPING = "/person-analyzer";

    private final PersonAnalyzerService service;

    @Inject
    PersonAnalyzerController(PersonAnalyzerService service) {
        this.service = service;
    }

    @ApiOperation("Grąžinti formatuotą infromaciją apie žmogų.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Neplanuota klaida."),
            @ApiResponse(code = 200, message = "Informacija sėkmingai grąžinta.")})
    @RequestMapping(
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public String returnStatement(@RequestBody Person person) {
        return service.getPersonInfo(person);
    }
}
