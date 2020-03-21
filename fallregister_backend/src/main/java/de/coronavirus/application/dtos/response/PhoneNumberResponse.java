package de.coronavirus.application.dtos.response;

import de.coronavirus.domain.model.PhoneNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("PhoneNumber")
public class PhoneNumberResponse {
    @ApiModelProperty
    PhoneNumber phoneNumber;
}
