package com.vmware.airline.passengercheckindemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PassengerCheckinControllerTest {


    private PassengerCheckinController controller;
    private MockMvc mockMvc;
    private PassengerCheckinService mockPassengerCheckinService;

    @BeforeEach
    void setUp() {
        mockPassengerCheckinService = mock(PassengerCheckinService.class);
        controller = new PassengerCheckinController(mockPassengerCheckinService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Given a passenger name, when a request is sent, then respond with a personal greeting and status ok")
    void shouldGreetPassenger() throws Exception {
        // Given
        String jsonRequestBody = "{\"passenger\":\"Some Passenger\"}";

        // When
        MvcResult result = mockMvc.perform(get("/welcome")
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonRequestBody))
                .andExpect(status().isOk())
                .andReturn();

        // Then
        assertNotNull(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("When a welcome request is made, then should call the PassengerCheckinService")
    void shouldInvokeRassengerService() throws Exception {
        // Given
        String passenger = "Some Passenger";

        // When
        controller.welcome(passenger);

        // Then
        verify(mockPassengerCheckinService).getGreeting(passenger);
    }
}