package com.conversions.conversion.controller;

import com.conversions.conversion.exception.model.BadEntryException;
import com.conversions.conversion.service.MeasurementConversionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/measurementConversions")
@Api(tags = "Measurement Conversions Service")
public class MeasurementConversionsController {

    private static Logger logger = LoggerFactory.getLogger(MeasurementConversionsController.class);

    @Autowired
    private MeasurementConversionsService measurementConversionsService;

    /**
     * @param kelvinValue
     * @return celsiusValue
     */
    @ApiOperation(value = "Gets kelvin to Celsius")
    @GetMapping(path = "/kelvinToCelsius", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> getkelvinToCelsius(@RequestParam final double kelvinValue) {

        final double celsiusValue;

        if (kelvinValue != 0) {
            celsiusValue = measurementConversionsService.getkelvinToCelsius(kelvinValue);
        } else {
            throw new BadEntryException("Bad request", "Invalid kelvin entry " + kelvinValue);
        }

        return ResponseEntity.ok(celsiusValue);

    }

    /**
     * @param milesValue
     * @return kilometersValue
     */
    @ApiOperation(value = "Gets miles to kilometers")
    @GetMapping(path = "/MilestoKilometers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> getMilestoKilometers(@RequestParam final double milesValue) {

        final double kilometersValue;

        if (milesValue != 0) {
            kilometersValue = measurementConversionsService.getMilesToKilometers(milesValue);
        } else {
            throw new BadEntryException("Bad request", "Invalid miles Value entry " + milesValue);
        }

        return ResponseEntity.ok(kilometersValue);
    }

    /**
     * @param poundsValue
     * @return kilogramsValue
     */
    @ApiOperation(value = "Gets pounds to kilograms")
    @GetMapping(path = "/poundsToKilograms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> getpoundsToKilograms(@RequestParam final double poundsValue) {

        final double kilogramsValue;

        if (poundsValue != 0) {
            kilogramsValue = measurementConversionsService.getPoundsToKilograms(poundsValue);
        } else {
            throw new BadEntryException("Bad request", "Invalid pounds Value entry " + poundsValue);
        }


        return ResponseEntity.ok(kilogramsValue);
    }

}
