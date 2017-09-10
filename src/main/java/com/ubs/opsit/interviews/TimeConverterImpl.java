package com.ubs.opsit.interviews;

/**
 * Created by rohit on 9/10/2017.
 */
public class TimeConverterImpl implements TimeConverter
{
    @Override
    public String convertTime(String currentTime) {
        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setClockTime(currentTime);
        return berlinClock.toString();
    }
}

