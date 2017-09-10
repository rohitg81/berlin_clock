package com.ubs.opsit.interviews;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by rohit on 9/10/2017.
 */
public class TimeConverterTest {

    private TimeConverter timeConverter;

    @Before
    public void setUp()
    {
        timeConverter = new TimeConverterImpl();
    }

    @After
    public void tearDown()
    {
        timeConverter = null;
    }

    @Test
    public void testBeforeMidnight()
    {
        String expected = "Y\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY";
        assertEquals(timeConverter.convertTime("23:59:00"),expected);
    }

    @Test
    public void testMidnight()
    {
        String expected = "Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO";
        assertEquals(timeConverter.convertTime("24:00:00"),expected);
    }

    @Test
    public void testMiddleOfMidnight()
    {
        String expected = "O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO";
        assertEquals(timeConverter.convertTime("13:17:01"),expected);
    }

    @Test
    public void testMidnightWhenAllLampsAreOff()
    {
        String expected = "Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO";
        assertEquals(timeConverter.convertTime("00:00:00"),expected);
    }

}
