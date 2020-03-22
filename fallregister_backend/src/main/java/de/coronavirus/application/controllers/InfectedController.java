package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.InfectedAPI;
import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.response.InfectedResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class InfectedController implements InfectedAPI {
    @Override
    public List<InfectedResponse> getAllInfectedEntries() {
        return null;
    }

    @Override
    public InfectedResponse getInfectedEntry(long id) {
        return null;
    }

    @Override
    public InfectedResponse createInfectedEntry(CreateInfectedRequest newInfected) {
        return null;
    }

    @Override
    public InfectedResponse updateInfectedEntry(long id, UpdateInfectedRequest request) {
        return null;
    }

    @Override
    public boolean deleteInfectedEntry(long id) {
        return false;
    }

}
