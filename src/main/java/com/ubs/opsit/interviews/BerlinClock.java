package com.ubs.opsit.interviews;

import java.util.Arrays;

/**
 * Created by rohit on 9/10/2017.
 */
public class BerlinClock {

    private String[] hourFirst = {"O","O","O","O"};
    private String[] hourSecond = {"O","O","O","O"};
    private String[] minFirst = {"O","O","O","O","O","O","O","O","O","O","O"};
    private String[] minSecond = {"O","O","O","O"};
    private String   clockTop = "Y";

    public void setClockTime(String currentTime)
    {
        String[] clockParts = currentTime.split(":");
        int hourPart = Integer.parseInt(clockParts[0]);
        int minPart = Integer.parseInt(clockParts[1]);
        int topPart = Integer.parseInt(clockParts[2]);
        calculateClockParts(hourPart,minPart,topPart);
    }

    private void calculateClockParts(int hourPart,int minPart,int topPart) {

        int topHourOnCount = hourPart/5;
        int bottomHourOnCount = hourPart%5;
        int topMinCount  = minPart/5;
        int bottomMin = minPart%5;

        setClockTop(topPart);
        setHourRows(hourFirst,topHourOnCount);
        setHourRows(hourSecond,bottomHourOnCount);
        setTopMinRow(topMinCount);
        setBottomMinRow(bottomMin);

    }

    private void setClockTop(int value)
    {
        if(value!=0)
        {
            clockTop  = "O";
        }
    }

    private void setHourRows(String[] arr, int count) {
       for(int i=0;i<count;i++)
       {
           arr[i]="R";
       }
    }
    private void setBottomMinRow(int count) {
        for(int i=0;i<count;i++)
        {
            minSecond[i]="Y";
        }
    }

    private void setTopMinRow(int count) {

        for(int i=0;i<count;i++)
        {
            if(i==2|| i == 5 || i ==8)
            {
                minFirst[i]="R";
            }
            else {
                minFirst[i] = "Y";
            }

        }
    }

    private String concatenateStringArray(String[] s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i++)
        {
            sb.append(s[i]);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getClockTop() +System.lineSeparator()+
                concatenateStringArray(getHourFirst()) +System.lineSeparator()+
                concatenateStringArray(getHourSecond()) +System.lineSeparator()+
                concatenateStringArray(getMinFirst()) +System.lineSeparator()+
                concatenateStringArray(getMinSecond());


    }

    public String[] getHourFirst() {
        return hourFirst;
    }

    public String[] getHourSecond() {
        return hourSecond;
    }

    public String[] getMinFirst() {
        return minFirst;
    }

    public String[] getMinSecond() {
        return minSecond;
    }

    public String getClockTop() {
        return clockTop;
    }
}
