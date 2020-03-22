package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.response.autocomplete.ACAddressResponse;
import de.coronavirus.application.dtos.response.autocomplete.ACDiagnosisNameResponse;
import de.coronavirus.application.dtos.response.autocomplete.ACLaboratoryNameResponse;
import de.coronavirus.application.dtos.response.autocomplete.ACStreetNameResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"autocomplete"}, description = "Corona-Virus Autocomplete API")
@RequestMapping("/autocomplete")
public interface AutocompleteApi {

    @GetMapping("/diagnosisname")
    @ApiOperation(value =  "Responds with list of diagnosis names whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching names")
    })
    ACDiagnosisNameResponse autocompleteDiagnosisName(@Valid @RequestParam String partialDiagnosisName);

    @GetMapping("/laboratoryname")
    @ApiOperation(value =  "Responds with list of laboratory names whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching names")
    })
    ACLaboratoryNameResponse autocompleteLaboratoryName(@Valid @RequestParam String partialLaboratoryName);

    @GetMapping("/street")
    @ApiOperation(value =  "Responds with list of streets whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching streets")
    })
    ACStreetNameResponse autocompleteStreet(@Valid @RequestParam String partialStreet);

    @GetMapping("/postCode")
    @ApiOperation(value =  "Responds with list of streets whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching streets")
    })
    List<ACAddressResponse> autocompletePostalCode(@Valid @RequestParam String partialStreet);

    @GetMapping("/city")
    @ApiOperation(value =  "Responds with list of streets whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching streets")
    })
    List<ACAddressResponse> autocompleteCity(@Valid @RequestParam String partialCity);

    @GetMapping("/country")
    @ApiOperation(value =  "Responds with list of streets whose name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching streets")
    })
    List<ACAddressResponse> autocompleteCountry(@Valid @RequestParam String partialCountry);

}
