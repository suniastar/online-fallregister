package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Address")
public class AddressResponse {
    @ApiModelProperty(position = 1)
    String cityName;
    @ApiModelProperty(position = 2)
    long postCode;
    @ApiModelProperty(position = 3)
    String streetName;
    @ApiModelProperty(position =  4)
    int houseNumber;
}
