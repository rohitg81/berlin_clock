package com.ubs.opsit.interviews;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by rohit on 9/10/2017.
 */
public class BerlinClockTest {
    private String[] hourFirst = {"O","O","O","O"};
    private String[] hourSecond = {"O","O","O","O"};
    private String[] minFirst = {"O","O","O","O","O","O","O","O","O","O","O"};
    private String[] minSecond = {"O","O","O","O"};
    private String   clockTop = "Y";

    private BerlinClock berlinClock;

    @Before
    public void setUp()
    {
        berlinClock = new BerlinClock();
    }

    @After
    public void tearDown()
    {
        berlinClock = null;
    }

    @Test
    public void testClockPartLengths()
    {
        berlinClock.setClockTime("23:59:59");
        assertEquals(berlinClock.getHourFirst().length,hourFirst.length);
        assertEquals(berlinClock.getHourSecond().length,hourSecond.length);
        assertEquals(berlinClock.getMinFirst().length,minFirst.length);
        assertEquals(berlinClock.getMinSecond().length,minSecond.length);
    }

    //Tests for clock top part
    @Test
    public void testClockTopIsOn()
    {
        berlinClock.setClockTime("23:59:59");
        assertEquals(berlinClock.getClockTop(),"O");
    }
    @Test
    public void testClockTopIsOff()
    {
        berlinClock.setClockTime("23:59:00");
        assertEquals(berlinClock.getClockTop(),"Y");
    }

    // Tests for Top Hour Part
    @Test
    public void testTopHourPartAllOn()
    {
        String[] expected = {"R","R","R","R"};
        berlinClock.setClockTime("23:59:59");
        assertArrayEquals(berlinClock.getHourFirst(),expected);
    }

    @Test
    public void testTopHourPartAllOff()
    {
        String[] expected = {"O","O","O","O"};
        berlinClock.setClockTime("00:59:59");
        assertArrayEquals(berlinClock.getHourFirst(),expected);
    }

    @Test
    public void testTopHourPartFirstTwoOn()
    {
        String[] expected = {"R","R","O","O"};
        berlinClock.setClockTime("12:59:59");
        assertArrayEquals(berlinClock.getHourFirst(),expected);
    }

    @Test
    public void testTopHourPartFirstThreeOn()
    {
        String[] expected = {"R","R","R","O"};
        berlinClock.setClockTime("17:59:59");
        assertArrayEquals(berlinClock.getHourFirst(),expected);
    }

    // Tests for Bottom Hour Part
    @Test
    public void testBottomHourFirstThreeOn()
    {
        String[] expected = {"R","R","R","O"};
        berlinClock.setClockTime("18:59:59");
        assertArrayEquals(berlinClock.getHourSecond(),expected);
    }


    @Test
    public void testBottomHourAllOn()
    {
        String[] expected = {"R","R","R","R"};
        berlinClock.setClockTime("19:59:59");
        assertArrayEquals(berlinClock.getHourSecond(),expected);
    }
    @Test
    public void testBottomHourAllOff()
    {
        String[] expected = {"O","O","O","O"};
        berlinClock.setClockTime("15:59:59");
        assertArrayEquals(berlinClock.getHourSecond(),expected);
    }


    // Tests for Top Minute Part
    @Test
    public void testMinuteHourFirstThreeOn()
    {
        String[] expected = {"Y","Y","R","O","O","O","O","O","O","O","O"};
        berlinClock.setClockTime("18:17:59");
        assertArrayEquals(berlinClock.getMinFirst(),expected);
    }


    @Test
    public void testMinuteHourFirstEightOn()
    {
        String[] expected = {"Y","Y","R","Y","Y","R","Y","Y","R","O","O"};
        berlinClock.setClockTime("19:45:59");
        assertArrayEquals(berlinClock.getMinFirst(),expected);
    }
    @Test
    public void testMinuteHourAllOff()
    {
        String[] expected = {"O","O","O","O","O","O","O","O","O","O","O"};
        berlinClock.setClockTime("15:00:00");
        assertArrayEquals(berlinClock.getMinFirst(),expected);
    }

    // Tests for Bottom Minute Part
    @Test
    public void testMinuteBottomAllOn()
    {
        String[] expected = {"Y","Y","Y","Y"};
        berlinClock.setClockTime("18:19:59");
        assertArrayEquals(berlinClock.getMinSecond(),expected);
    }

    @Test
    public void testMinuteBottomFirstThreeOn()
    {
        String[] expected = {"Y","Y","Y","O"};
        berlinClock.setClockTime("19:43:59");
        assertArrayEquals(berlinClock.getMinSecond(),expected);
    }
    @Test
    public void testMinuteBottomAllOff()
    {
        String[] expected = {"O","O","O","O"};
        berlinClock.setClockTime("15:20:00");
        assertArrayEquals(berlinClock.getMinSecond(),expected);
    }
}
