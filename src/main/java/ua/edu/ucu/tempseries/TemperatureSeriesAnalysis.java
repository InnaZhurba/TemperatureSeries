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
        length = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        checking(temperatureSeries);

        checkSeriesIsValid(temperatureSeries);
        this.length = temperatureSeries.length;
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }
    public void checkSeriesIsValid(double[] temperatureSeries){
        int minTemp = -273;
        for (double temperatureSery : temperatureSeries) {

            if (temperatureSery <= minTemp) {
                throw new InputMismatchException();
            }
        }
    }

    public double average() {

        double sum = Arrays.stream(getTemperatureSeries()).sum();

        return sum/length;
    }

    public double deviation() {
        checking(this.temperatureSeries);

        double sum =0;
        double average =average();

        for(double temp: temperatureSeries)
            sum+=Math.pow(temp - average,2);

        return sum/length;
    }
    private void checking(double[] temperatureSeries){

        if(temperatureSeries.length==0) {
            throw new IllegalArgumentException();
        }
    }

    public double min() {
       checking(this.temperatureSeries);

        double min= Double.POSITIVE_INFINITY;

        for(double temp:temperatureSeries)
            if(temp<min)
                min = temp;
        return min;
    }

    public double max() {
        checking(this.temperatureSeries);

        double max= Double.NEGATIVE_INFINITY;

        for(double temp:temperatureSeries)
            if(temp>max)
                max = temp;
        return max;
    }

    public double findTempClosestToZero() {
        checking(this.temperatureSeries);

        double minDiff = Double.POSITIVE_INFINITY;
        //double closestValue;
        //можна просто викликати findTempClosestToValue(0)
        for(double temp: temperatureSeries){

            if(Math.abs(temp-0) < Math.abs(minDiff-0) || (temp == -minDiff && temp>0)){
                minDiff = temp;
            }
            /*if(temp>0 && Math.abs(temp-0)==minDiff){

            }*/
        }
        return minDiff;
    }

    public double findTempClosestToValue(double tempValue) {
       checking(this.temperatureSeries);

        double closestValue = Double.POSITIVE_INFINITY;

        for(double temp: temperatureSeries)
            if(Math.abs(temp-0) < Math.abs(closestValue-0) || (temp == -closestValue && temp>0))
                closestValue=temp;

        return closestValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        checking(this.temperatureSeries);

        int counter=0;
        double[] newArray;
        for(int i=0;i<length;i++){
            if(temperatureSeries[i]<tempValue) {
                //double template[] = new double[i+1];
                double temp = temperatureSeries[i];
                temperatureSeries[i]= temperatureSeries[counter];
                temperatureSeries[counter] = temp;
                counter++;
            }
        }
        newArray = new double[counter];
        System.arraycopy(temperatureSeries, 0, newArray, 0, counter);
        //double newArray[] = temperatureSeries[0counter];
        return newArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        checking(this.temperatureSeries);

        int counter=0;
        double[] newArray;
        for(int i=0;i<length;i++){
            if(temperatureSeries[i]>=tempValue) {
                //double template[] = new double[i+1];
                double temp = temperatureSeries[i];
                temperatureSeries[i]= temperatureSeries[counter];
                temperatureSeries[counter] = temp;
                counter++;
            }
        }
        newArray = new double[counter];
        System.arraycopy(temperatureSeries, 0, newArray, 0, counter);
        return newArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        checking(this.temperatureSeries);

        //if(summaryStatistics == null)
        //    throw new IllegalArgumentException();

        return new TempSummaryStatistics(average(),deviation(),min(),max());
    }

    public int addTemps(double... temps) {
        checkSeriesIsValid(temps);

        if(length + temps.length >=temperatureSeries.length)
            changeSizeArr();

        if (temps.length - length >= 0)
            System.arraycopy(temps, 0, temperatureSeries, length, temps.length - length);
        length+=temps.length;

        return length;
    }
    public void changeSizeArr(){
        double[] newTemperatureSeries = new double[temperatureSeries.length*2];
        System.arraycopy(temperatureSeries, 0, newTemperatureSeries, 0, temperatureSeries.length);
        temperatureSeries=newTemperatureSeries;
    }
}
