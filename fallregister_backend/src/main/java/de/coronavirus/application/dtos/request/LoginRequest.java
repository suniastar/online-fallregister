package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("LoginRequest")
public class LoginRequest {

    @NotEmpty
    @ApiModelProperty( required = true)
    String user;

    @NotEmpty
    @ApiModelProperty( required = true)
    String password;
}
