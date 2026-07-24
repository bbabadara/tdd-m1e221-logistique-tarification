package com.logistique.tarification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class DeliveryPricingEngineTest {

    @Mock
    WeatherAlertPort weatherAlertPort;

    DeliveryPricingEngine engine;

    @BeforeEach
    void setup() {
        engine = new DeliveryPricingEngine(weatherAlertPort);
    }

    @Test
    void shouldReturn2000ForUrbanZone() {

        when(weatherAlertPort.hasFloodAlert(anyString()))
                .thenReturn(false);

        int price = engine.calculate(
                Zone.URBAN,
                3,
                false,
                "Dakar");

        assertEquals(2000, price);
    }

}
