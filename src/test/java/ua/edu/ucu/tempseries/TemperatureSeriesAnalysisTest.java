package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {-1.0,-0.2,0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.1;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(0);

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-1.0,-0.2,-0.1,-0.2};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsLessThen(0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {0.2,1.0};

        // call tested method
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0);

        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] newArr = {0.2,1.0};
        int expResult = temperatureSeries.length+newArr.length;

        // call tested method
        int actualResult = seriesAnalysis.addTemps(newArr);

        // compare expected result with actual result
        assertEquals(expResult,actualResult);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.3525;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult,actualResult, 0.001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult,actualResult, 0.001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-1.0,-0.2,-0.1, 0.2,1.0,-0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult,actualResult, 0.001);
    }
}
