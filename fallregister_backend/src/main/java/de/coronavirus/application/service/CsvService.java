package de.coronavirus.application.service;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CsvService {

    public final InfectedService infectedService;

    @Autowired
    public CsvService(InfectedService infectedService){
        this.infectedService = infectedService;
    }

    public void createInfectedFromCsv(String csv){


        CreateInfectedRequest createInfectedRequest = new CreateInfectedRequest();
        infectedService.createInfected(createInfectedRequest);
    }

}
