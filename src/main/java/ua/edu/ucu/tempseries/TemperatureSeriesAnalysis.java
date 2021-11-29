package ua.edu.ucu.tempseries;

import lombok.Getter;

import java.util.Arrays;
import java.util.InputMismatchException;

@Getter
public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private int length;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new double[]{};
        length = temperatureSeries.length;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if(temperatureSeries == null || temperatureSeries.length==0)
            return;
        checkSeriesIsValid(temperatureSeries);
        this.length = temperatureSeries.length;
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }
    public void checkSeriesIsValid(double[] temperatureSeries){
        int minTemp = -273;
        for(int i=0;i<temperatureSeries.length;i++){
            if(temperatureSeries[i]<=minTemp)
                throw new InputMismatchException();
        }
    }

    public double average() {
        return -1;
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        return 0;
    }

    public double max() {
        return 0;
    }

    public double findTempClosestToZero() {
        if(getTemperatureSeries().length==0)
            throw new IllegalArgumentException();

        double minDiff = Double.POSITIVE_INFINITY;
        double closestValue;
        for(double temp: temperatureSeries){
            if(Math.abs(temp-0) < minDiff){
                minDiff = temp;
            }
            if(temp>0 && Math.abs(temp-0)==minDiff){

            }
        }
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
