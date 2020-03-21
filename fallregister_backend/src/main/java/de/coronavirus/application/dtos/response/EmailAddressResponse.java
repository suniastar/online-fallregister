package de.coronavirus.application.dtos.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("EmailAddress")
public class EmailAddressResponse {

    @ApiModelProperty(position = 1)
    List<String> emailAddress;

    public List<String> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(List<String> emailAddress) {
        this.emailAddress = emailAddress;
    }
}
