package de.coronavirus.application.dtos.mapper;

import java.util.ArrayList;
import java.util.List;

import de.coronavirus.domain.model.Infected;
import de.coronavirus.domain.model.PhoneNumber;

public class ToModelConverter {

    public static PhoneNumber stringsToPhoneNumber(String phonenumber) {
        PhoneNumber number = new PhoneNumber();
        number.setNumber(phonenumber);
        return number;
    }

    public static List<PhoneNumber> stringsToPhoneNumber(String ... phonenumbers) {
        List<PhoneNumber> resultNumbers = new ArrayList<PhoneNumber>(phonenumbers.length);
        for(String phoneNumberString : phonenumbers) {
            stringsToPhoneNumber(phoneNumberString);
        }
        return resultNumbers;
    }

    /**
     * Coverts a String to an Infected.Gender Object
     * @param genderString the String which describes the gender, expected values are "female", "male", "other" = diverse
     *                     default is diverse if and only if the parameter String does not match the predefined values
     * @return an Infected.Gender
     */
    public static Infected.Gender stringToGender(String genderString) {
        Infected.Gender genderOfInfected = Infected.Gender.DIVERSE;
        switch (genderString) {
            case "female":
                genderOfInfected = Infected.Gender.FEMALE;
                break;
            case "male":
                genderOfInfected = Infected.Gender.MALE;
                break;
            case "other":
                genderOfInfected = Infected.Gender.DIVERSE;
                break;
            default:
                genderOfInfected = Infected.Gender.DIVERSE;
        }
        return genderOfInfected;
    }

    /**
     * Converts a list of strings into a list of Infected.Gender. Helperfunction to help to convert list of Strings to
     * a list of Infected.Gender
     * @param genderStrings the String which describes the gender, expected values are "female", "male", "other" = diverse
     *                      default is diverse if and only if the parameter String does not match the predefined values
     * @return an Infected.Gender
     */
    public static List<Infected.Gender> stringToGender(String ... genderStrings) {
        List<Infected.Gender> resultGenders = new ArrayList<Infected.Gender>(genderStrings.length);
        for(String genderString : genderStrings) {
            resultGenders.add(stringToGender(genderString));
        }
        return resultGenders;
    }
}
