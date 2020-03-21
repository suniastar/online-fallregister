package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.request.Login;
import de.coronavirus.application.dtos.request.RefreshSession;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@Api(value = "/auth")
public interface Authentication {

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Tries to login the User and returns a Sessiontoken", code = 200)
    @ApiResponse(code = 404, message = "User not found or password does not match with the given username!")
    Token postLogin(@RequestBody Login loginRequest);

    @PostMapping(value = "/refresh")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Tries to refresh the Users Sessiontoken and returns the  Sessiontoken", code = 200)
    @ApiResponse(code = 404, message = "Sessiontoken invalid, refresh failed!")
    Token postRefresh(@RequestBody RefreshSession refreshRequest);

}
