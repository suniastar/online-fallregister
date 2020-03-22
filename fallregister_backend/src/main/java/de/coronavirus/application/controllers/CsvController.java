package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.CsvApi;
import de.coronavirus.application.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CsvController implements CsvApi {

    private final CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService){
        this.csvService = csvService;
    }

    @Override
    public void putCsv(@RequestBody String csv) {
        csvService.createInfectedFromCsv(csv);
    }
}
