package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.request.CreateInfectedRequest;
import de.coronavirus.application.dtos.request.UpdateInfectedRequest;
import de.coronavirus.application.dtos.response.InfectedResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = {"infected"}, description = "Corona-Virus Backend Infected API")
@RequestMapping("/infected")
public interface InfectedAPI {


    /* * * * * * * * * * * * * *
     *      GET - Methods      *
     * * * * * * * * * * * * * */

    @GetMapping
    @ApiOperation( value = "Finds all listed infected")
    List<InfectedResponse> getAllInfectedEntries();

    @GetMapping("/{id}")
    @ApiOperation( value = "Finds a specific infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "infected not found")
    })
    InfectedResponse getInfectedEntry(@PathVariable long id);


    /* * * * * * * * * * * * * *
     *     CREATE - Methods    *
     * * * * * * * * * * * * * */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation( value = "Creates a new infected")
    InfectedResponse createInfectedEntry(@RequestBody CreateInfectedRequest newInfected);


    /* * * * * * * * * * * * * *
     *     UPDATE - Methods    *
     * * * * * * * * * * * * * */

    @PostMapping("/{id}")
    @ApiOperation(value = "Updates fields of existing infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Infected not found")
    })
    InfectedResponse updateInfectedEntry(@PathVariable long id, @RequestBody UpdateInfectedRequest request);


    /* * * * * * * * * * * * * *
     *     DELETE - Methods    *
     * * * * * * * * * * * * * */

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes an existing infected")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Infected not found")
    })
    boolean deleteInfectedEntry(@PathVariable long id);

}