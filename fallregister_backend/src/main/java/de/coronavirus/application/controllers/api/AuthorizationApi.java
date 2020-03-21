package de.coronavirus.application.controllers.api;

import de.coronavirus.application.dtos.request.Login;
import de.coronavirus.application.dtos.request.RefreshSession;
import de.coronavirus.application.dtos.response.TokenResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/auth")
@Api(value = "/auth")
public interface AuthorizationApi {

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Tries to login the User and returns a Sessiontoken")
    @ApiResponses({
            @ApiResponse(code = 401, message = "Invalid credentials")
    })
    TokenResponse postLogin(@RequestBody Login loginRequest);

    @PostMapping(value = "/refresh")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Tries to refresh the Users Sessiontoken and returns the  Sessiontoken")
    @ApiResponses({
            @ApiResponse(code = 401, message = "Out-dated token credentials")
    })
    TokenResponse postRefresh(@RequestBody RefreshSession refreshRequest);

}
