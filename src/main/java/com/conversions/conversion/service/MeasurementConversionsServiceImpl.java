package com.conversions.conversion.service;


import org.springframework.stereotype.Service;

@Service
public class MeasurementConversionsServiceImpl implements MeasurementConversionsService {


    final public static double KelvinFormula = 273.15d;
    final public static double MilesKilometers = 0.62137d;
    final public static double PoundKilometers = 0.45359237d;

    @Override
    public double getkelvinToCelsius(double kelvin) {
        return (kelvin - KelvinFormula);

    }

    @Override
    public double getMilesToKilometers(double milesValues) {
        return milesValues / MilesKilometers;
    }


    @Override
    public double getPoundsToKilograms(double poundsValue) {
        return poundsValue * PoundKilometers;
    }

}
