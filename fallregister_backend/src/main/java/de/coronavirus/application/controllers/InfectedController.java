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

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class InfectedController implements InfectedApi {

    private final InfectedService infectedService;

    @Autowired
    public InfectedController(InfectedService infectedService) {
        this.infectedService = infectedService;
    }

    @Override
    public List<InfectedResponse> getAllInfectedEntries() {
        return InfectedMapper.toResponseList(infectedService.findAll());
    }

    @Override
    public InfectedResponse getInfectedEntry(@PathVariable long id) {
        return InfectedMapper.toResponse(infectedService.findInfected(id));
    }

    @Override
    public InfectedResponse createInfectedEntry(@Valid @RequestBody CreateInfectedRequest request) {
        return InfectedMapper.toResponse(infectedService.createInfected(request));
    }

    @Override
    public InfectedResponse updateInfectedEntry(@Valid @PathVariable long id, @RequestBody UpdateInfectedRequest request) {
        return InfectedMapper.toResponse(infectedService.updateInfected(request, id));
    }

    @Override
    public void deleteInfectedEntry(@PathVariable long id) {
        infectedService.delete(id);
    }

}
