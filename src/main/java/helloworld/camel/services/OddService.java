package helloworld.camel.services;

import helloworld.camel.services.api.OddChecker;
import helloworld.camel.services.api.Div2Remainder;

public class OddService implements OddChecker, Div2Remainder {
    public Integer getDivisionReminder(Integer number) {
        return number % 2;
    }

    public String checkNumber(String number) {
        return "AAA";
    }

    public Boolean checkNumber(Integer number) {
        return null;
    }
}
