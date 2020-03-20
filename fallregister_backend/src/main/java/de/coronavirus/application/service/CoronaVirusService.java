package de.coronavirus.application.service;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Timed
@Service
@Transactional
public class CoronaVirusService {


    @Autowired
    public CoronaVirusService(/* TODO add possible repositories here and make them attributes */) {

    }

    // TODO define Controller methods here
}
