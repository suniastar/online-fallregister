package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.response.InfectedResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;


@Api(tags = {"infected"}, description = "Corona-Virus Infected API")
@RequestMapping("/infected")
public interface InfectedApi {


    /* * * * * * * * * * * * * *
     *      GET - Methods      *
     * * * * * * * * * * * * * */

    @GetMapping
    @ApiOperation(value = "Finds all listed infected")
    List<InfectedResponse> getAllInfectedEntries();

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds a specific infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "infected not found")
    })
    InfectedResponse getInfectedEntry(@PathVariable long id);


    /* * * * * * * * * * * * * *
     *     CREATE - Methods    *
     * * * * * * * * * * * * * */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a new infected")
    @ApiResponses({
            @ApiResponse(code = 400, message = "infected was not valid")
    })
    InfectedResponse createInfectedEntry(@Valid @RequestBody CreateInfectedRequest request);


    /* * * * * * * * * * * * * *
     *     UPDATE - Methods    *
     * * * * * * * * * * * * * */

    @PostMapping("/{id}")
    @ApiOperation(value = "Updates fields of existing infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "infected not found"),
            @ApiResponse(code = 400, message = "request was not valid")
    })
    InfectedResponse updateInfectedEntry(@PathVariable long id, @Valid @RequestBody UpdateInfectedRequest request);


    /* * * * * * * * * * * * * *
     *     DELETE - Methods    *
     * * * * * * * * * * * * * */

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes an existing infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "infected not found")
    })
    void deleteInfectedEntry(@PathVariable long id);

}