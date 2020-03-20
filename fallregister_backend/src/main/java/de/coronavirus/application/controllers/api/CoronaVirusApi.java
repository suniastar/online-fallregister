package de.coronavirus.application.controllers.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"corona"}, description = "Corona-Virus Backend API")
@RequestMapping("/corona")
public interface CoronaVirusApi {

    // TODO define API here
}
