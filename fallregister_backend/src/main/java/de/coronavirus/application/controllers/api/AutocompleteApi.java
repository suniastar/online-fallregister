package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.response.AddressResponse;
import de.coronavirus.application.dtos.response.DiagnosisResponse;
import de.coronavirus.application.dtos.response.EmailAddressResponse;
import de.coronavirus.application.dtos.response.PhoneNumberResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = {"autocomplete"}, description = "Corona-Virus Autocomplete API")
@RequestMapping("/autocomplete")
public interface AutocompleteApi {

    @GetMapping("/phone")
    @ApiOperation(value = "Responds with list of phone numbers which begin with the given partial number")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching phone numbers")
    })
    PhoneNumberResponse autocompletePhone(@RequestParam String partialPhone);

    @GetMapping("/email")
    @ApiOperation(value =  "Responds with list of emails which begin with the given String")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching email addresses")
    })
    EmailAddressResponse autocompleteEmail(@RequestParam String partialEmail);


    @GetMapping("/address")
    @ApiOperation(value =  "Responds with list of Addresses whose street name begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching addresses")
    })
    List<AddressResponse> autocompleteAddress(@RequestParam String partialStreet);

    @GetMapping("/diagnosis")
    @ApiOperation(value =  "Responds with list of diagnosis results that begin with the given string")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Did not find any matching diagnoses")
    })
    DiagnosisResponse autocompleteDiagnosis(@RequestParam String partialDiagnosis);

}
