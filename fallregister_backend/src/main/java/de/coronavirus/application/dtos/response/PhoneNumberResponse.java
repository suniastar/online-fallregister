package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("PhoneNumber")
public class PhoneNumberResponse {
    @ApiModelProperty
    List<String> phoneNumber;
}
