package de.coronavirus.application.controllers.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"csv"}, description = "Corona Virus CSV API")
@RequestMapping("/csv")
public interface CsvApi {

    @PutMapping
    @ApiOperation(value = "Create new infected from CSV")
    @ApiResponses({
            @ApiResponse(code = 400, message = "csv was not valid")
    })
    void putCsv(@RequestBody String csv);
}
