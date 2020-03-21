package de.coronavirus.application.dtos.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("LoginRequest")
public class LoginRequest {

    @ApiModelProperty(position = 1, required = true)
    String user;

    @ApiModelProperty(position = 2, required = true)
    String password;
}
