package de.coronavirus.application.controllers.api;

import de.coronavirus.domain.model.Address;
import de.coronavirus.domain.model.Diagnosis;
import de.coronavirus.domain.model.EmailAddress;
import de.coronavirus.domain.model.PhoneNumber;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = {"autocomplete"}, description = "Corona-Virus Autocomplete API")
@RequestMapping("/corona")
public interface AutocompleteApi {

    @GetMapping("phone")
    @ApiOperation(value = "Liefert eine Liste an Telefonnummern zurück die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Telefonnummer gefunden")
    })
    List<PhoneNumber> autocompletePhone(@RequestParam String partialPhone);

    @GetMapping("email")
    @ApiOperation(value =  "Liefert eine Liste an E-Mails zurück, die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende E-Mail gefunden")
    })
    List<EmailAddress> autocompleteEmail(@RequestParam String partialStreet);


    @GetMapping("address")
    @ApiOperation(value =  "Liefert eine Liste an Adressen zurück, die mit gegebenen Straßennamensstück enthalten")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Adresse gefunden")
    })
    List<Address> autocompleteAddress(@RequestParam String partialStreet);

    @GetMapping("diagnosis")
    @ApiOperation(value =  "Liefert eine Liste an Diagnosen zurück, die mit gegebenen Anfangsstück beginnen")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Keine passende Diagnose gefunden")
    })
    List<Diagnosis> autocompleteDiagnosis(@RequestParam String partialDiagnosis);

}
