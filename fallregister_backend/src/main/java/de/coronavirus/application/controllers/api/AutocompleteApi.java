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
    @ApiOperation(value = "Liefert eine Liste an Telefonnummern zurück die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Telefonnummer gefunden")
    })
    PhoneNumberResponse autocompletePhone(@RequestParam String partialPhone);

    @GetMapping("/email")
    @ApiOperation(value =  "Liefert eine Liste an E-Mails zurück, die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende E-Mail gefunden")
    })
    EmailAddressResponse autocompleteEmail(@RequestParam String partialEmail);


    @GetMapping("/address")
    @ApiOperation(value =  "Liefert eine Liste an Adressen zurück, die mit gegebenen Straßennamensstück enthalten")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Adresse gefunden")
    })
    List<AddressResponse> autocompleteAddress(@RequestParam String partialStreet);

    @GetMapping("/diagnosis")
    @ApiOperation(value =  "Liefert eine Liste an Diagnosen zurück, die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Diagnose gefunden")
    })
    DiagnosisResponse autocompleteDiagnosis(@RequestParam String partialDiagnosis);

}
