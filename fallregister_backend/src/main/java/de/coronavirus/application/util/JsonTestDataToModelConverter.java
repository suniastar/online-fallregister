package de.coronavirus.application.util;

import de.coronavirus.domain.model.Infected;
import io.swagger.models.auth.In;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonTestDataToModelConverter {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String GENDER = "gender";
    private static final String DATE_OF_BIRTH = "dateOfBirth";
    private static final String DATE_OF_IILLNESS = "dateOfIllness";
    private static final String DATE_OF_DEATH = "dateOfDeath";
    private static final String INFECTION_SOURCE = "infectionSource";

    public static List<Infected> stringsToInfected(List<ComplexJsonDataUnwrapper.KeyValue> keyValues) {
        List<Infected> infectedList = new ArrayList<>(keyValues.size());
        Infected infected = new Infected();
        for (ComplexJsonDataUnwrapper.KeyValue keyValue : keyValues) {
            switch (keyValue.getKey()) {
                case FIRST_NAME :
                    infected.setFirstName(keyValue.getValue());
                    break;
                case LAST_NAME :
                    infected.setLastName(keyValue.getValue());
                    break;
                case GENDER :
                    infected.setGender(Infected.Gender.valueOf(keyValue.getValue()));
                    break;
                case DATE_OF_BIRTH :
                    infected.setDateOfBirth(stringDateToDate(keyValue.getValue()));
                    break;
                case DATE_OF_IILLNESS :
                    infected.setDateOfIllness(stringDateToDate(keyValue.getValue()));
                    break;
                case DATE_OF_DEATH :
                    infected.setDateOfDeath(stringDateToDate(keyValue.getValue()));
                    break;
                case INFECTION_SOURCE :
                    infected.setInfectionSource(keyValue.getValue());
                    infectedList.add(infected);
                    infected = new Infected();
                    break;
            }
        }
        return infectedList;
    }


    /**
     * Expects a string in the following pattern "dd,mm,yyyy" eg. "01,05,2022" which refers to the first may in 2022
     * @param date date in the pattern such as above where dd are two numeric digit representing the day in a month,
     *                                                     mm are two numeric digit representing the month in a year,
     *                                                     yyyy are four numeric digit representing the year.
     * @return A date with the system local timezone and time set to 00:00 o'clock
     */
    public static Date stringDateToDate(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        String isoFormat = year + "-" + month + "-" + day;
        LocalDate localDate = LocalDate.parse(isoFormat, DateTimeFormatter.ISO_LOCAL_DATE);
        return TimeConverter.convertLocalDateToDate(localDate);
    }

}
