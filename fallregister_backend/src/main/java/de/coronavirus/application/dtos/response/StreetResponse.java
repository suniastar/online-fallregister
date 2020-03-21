package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("Street")
public class StreetResponse {
    @ApiModelProperty(position = 0)
    List<String> streets;
}
