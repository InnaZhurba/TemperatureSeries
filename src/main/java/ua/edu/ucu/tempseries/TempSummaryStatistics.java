package ua.edu.ucu.tempseries;

import lombok.Getter;

@Getter
public class TempSummaryStatistics {
    private double averageTemp,deviationTemp,minTemp,maxTemp;

    public TempSummaryStatistics(double averageTemp, double deviationTemp, double minTemp, double maxTemp){
        this.averageTemp = averageTemp;
        this.deviationTemp = deviationTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}
