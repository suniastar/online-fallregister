package de.coronavirus.application.controllers;

import de.coronavirus.application.controllers.api.InfectedApi;
import de.coronavirus.application.dtos.mapper.InfectedMapper;
import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.response.InfectedResponse;
import de.coronavirus.application.service.InfectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
public class InfectedController implements InfectedApi {

    private final InfectedService infectedService;
    private final InfectedMapper infectedMapper;

    @Autowired
    public InfectedController(InfectedService infectedService, InfectedMapper infectedMapper) {
        this.infectedService = infectedService;
        this.infectedMapper = infectedMapper;
    }

    @Override
    public List<InfectedResponse> getAllInfectedEntries() {
        return infectedMapper.toResponseList(infectedService.findAll());
    }

    @Override
    public InfectedResponse getInfectedEntry(@PathVariable long id) {
        return infectedMapper.toResponse(infectedService.findInfected(id).get());
    }

    @Override
    public InfectedResponse createInfectedEntry(@RequestBody CreateInfectedRequest newInfected) {
        return infectedMapper.toResponse(infectedService.createInfected(newInfected));
    }

    @Override
    public InfectedResponse updateInfectedEntry(@PathVariable long id, @RequestBody UpdateInfectedRequest request) {
        return infectedMapper.toResponse(infectedService.updateInfected(request, id));
    }

    @Override
    public boolean deleteInfectedEntry(@PathVariable long id) {
        infectedService.delete(id);
    }

}
