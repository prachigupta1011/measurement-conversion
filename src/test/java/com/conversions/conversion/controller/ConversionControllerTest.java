package com.conversions.conversion.controller;

import com.conversions.conversion.service.MeasurementConversionsService;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ConversionControllerTest {

    @InjectMocks
    private MeasurementConversionsController measurementConversionsController;

    @Mock
    private MeasurementConversionsService measurementConversionsService;

    private MockMvc mockMvc;

    private static MappingJackson2HttpMessageConverter buildJacksonConverter() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return new MappingJackson2HttpMessageConverter(builder.build());
    }

    @Before
    public void initializeMocks() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(measurementConversionsController)
                .setMessageConverters(buildJacksonConverter())
                .build();
    }

    @Test
    public void getkelvinToCelsius_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/measurementConversions/kelvinToCelsius")
                .param("kelvinValue", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(measurementConversionsService).getkelvinToCelsius(anyDouble());
        assertNotNull(jsonResponse);
    }

    @Test
    public void ctoK_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/measurementConversions/MilestoKilometers")
                .param("milesValue", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(measurementConversionsService).getMilesToKilometers(anyDouble());
        assertNotNull(jsonResponse);
    }

    @Test
    public void mtok_test() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/measurementConversions/poundsToKilograms")
                .param("poundsValue", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        verify(measurementConversionsService).getPoundsToKilograms(anyDouble());
        assertNotNull(jsonResponse);
    }
}
