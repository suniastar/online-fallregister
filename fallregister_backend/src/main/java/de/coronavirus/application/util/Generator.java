package de.coronavirus.application.util;

import java.util.concurrent.ThreadLocalRandom;

public class Generator {


    /**
     * @param probability the probability for 100% give 100.0d for 0% give 0.0d
     * @return boolean
     */
    public static boolean generateBolean(double probability) {
        assert probability >=0 && probability <= 100 : "The probability has to be between 0 and 100";
        int random = generateRandomIntBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(random < 0) {
            return false;
        }
        return true;
    }

    public static int generateRandomIntBetween(int lowerLimit, int upperLimit){
        int random = ThreadLocalRandom.current().nextInt(lowerLimit, upperLimit);
        assert random >= lowerLimit && random <= upperLimit : "Number is out of bounds";
        return random;
    }
}
