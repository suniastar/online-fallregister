package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("TokenResponse")
public class TokenResponse {
    @ApiModelProperty
    String token;

}
