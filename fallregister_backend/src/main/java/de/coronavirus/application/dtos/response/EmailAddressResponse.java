package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("EmailAddress")
public class EmailAddressResponse {
    @ApiModelProperty
    List<String> emailAddress;
}
